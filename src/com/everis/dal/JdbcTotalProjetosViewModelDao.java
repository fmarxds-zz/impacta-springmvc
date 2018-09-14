package com.everis.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.everis.mapper.TotalProjetosViewModelMapper;
import com.everis.viewmodels.TotalProjetosViewModel;

public class JdbcTotalProjetosViewModelDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public List<TotalProjetosViewModel> findProjetosByCliente() {
		List<TotalProjetosViewModel> totalProjetos = null;
		String sql = "SELECT "
						+ "C.NOME AS CLIENTE, "
						+ "COUNT(P.VALOR) AS QUANT, "
						+ "SUM(P.VALOR) AS TOTAL "
					+ "FROM "
						+ "clientes C, projetos P "
					+ "WHERE "
						+ "C.IDCLIENTE = P.IDCLIENTE "
					+ "GROUP BY "
						+ "C.NOME;";
		try {
			totalProjetos = jdbcTemplate.query(sql, new TotalProjetosViewModelMapper());
		} catch (Exception e) {
			throw e;
		}
		return totalProjetos;
	}
	
}
