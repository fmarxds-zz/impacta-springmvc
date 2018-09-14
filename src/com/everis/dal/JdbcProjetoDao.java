package com.everis.dal;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.everis.entidades.Projeto;
import com.everis.mapper.ProjetoMapper;

public class JdbcProjetoDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public void save(Projeto projeto) {
		String sql = "INSERT INTO projetos (IDCLIENTE, DOCUMENTO, DESCRICAO, DURACAO, VALOR) VALUES (?, ?, ?, ?, ?)";
		Object[] parametrosSql = new Object[] {projeto.getIdCliente(), projeto.getDocumento(), projeto.getDescricao(), projeto.getDuracao(), projeto.getValor()};
		try {
			jdbcTemplate.update(sql, parametrosSql);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Projeto findById(int idProjeto) {
		Projeto projeto = null;
		String sql = "SELECT * FROM projetos WHERE IDPROJETO = ?";
		Object[] parametrosSql = new Object[] {idProjeto};
		try {
			projeto = jdbcTemplate.queryForObject(sql, parametrosSql, new ProjetoMapper());
		} catch (Exception e) {
			throw e;
		}
		return projeto;
	}

	public List<Projeto> findAll() throws Exception {
		List<Projeto> projetos = new ArrayList<>();
		String sql = "SELECT * FROM projetos";
		try {
			projetos = jdbcTemplate.query(sql, new ProjetoMapper());
		} catch (Exception e) {
			throw e;
		}
		return projetos;
	}

}
