package com.everis.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.everis.mapper.ClienteProjetoViewModelMapper;
import com.everis.viewmodels.ClienteProjetoViewModel;

public class JdbcClienteProjetoViewModelDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public List<ClienteProjetoViewModel> findProjetosByClienteId(int idCliente) {
		List<ClienteProjetoViewModel> clienteProjeto = null;
		String sql = "SELECT "
						+ "C.NOME AS CLIENTE, "
						+ "P.DOCUMENTO AS DOCUMENTO, "
						+ "P.DESCRICAO AS DESCRICAO, "
						+ "P.VALOR AS VALOR "
					+ "FROM "
						+ "clientes C, projetos P "
					+ "WHERE "
						+ "C.IDCLIENTE = P.IDCLIENTE AND C.IDCLIENTE = ?;";
		Object[] parametrosSql = new Object[] {idCliente};
		try {
			clienteProjeto = jdbcTemplate.query(sql, parametrosSql, new ClienteProjetoViewModelMapper());
		} catch (Exception e) {
			throw e;
		}
		return clienteProjeto;
	}

}
