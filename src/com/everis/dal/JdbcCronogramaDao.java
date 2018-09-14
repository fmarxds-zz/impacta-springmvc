package com.everis.dal;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.everis.entidades.Cronograma;
import com.everis.mapper.CronogramaMapper;

public class JdbcCronogramaDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public void save(Cronograma cronograma) {
		String sql = "INSERT INTO cronogramas (IDPROJETO, DATA, DURACAO, DESCRICAO, CONCLUIDO) VALUES (?, ?, ?, ?, ?)";
		Object[] parametrosSql = new Object[] {cronograma.getIdProjeto(), cronograma.getDataSql(), cronograma.getDuracao(), cronograma.getDescricao(), cronograma.getConcluidoSql()};
		try {
			jdbcTemplate.update(sql, parametrosSql);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Cronograma findById(int idCronograma) {
		Cronograma cronograma = null;
		String sql = "SELECT * FROM cronogramas WHERE IDCRONOGRAMA = ?";
		Object[] parametrosSql = new Object[] {idCronograma};
		try {
			cronograma = jdbcTemplate.queryForObject(sql, parametrosSql, new CronogramaMapper());
		} catch (Exception e) {
			throw e;
		}
		return cronograma;
	}

	public List<Cronograma> findAll() throws Exception {
		List<Cronograma> cronogramas = new ArrayList<>();
		String sql = "SELECT * FROM cronogramas";
		try {
			cronogramas = jdbcTemplate.query(sql, new CronogramaMapper());
		} catch (Exception e) {
			throw e;
		}
		return cronogramas;
	}
	
}
