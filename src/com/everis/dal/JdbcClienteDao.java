package com.everis.dal;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.everis.entidades.Cliente;
import com.everis.mapper.ClienteMapper;

public class JdbcClienteDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public Cliente findById(int idCliente) {
		Cliente cliente = null;
		String sql = "SELECT * FROM clientes WHERE IDCLIENTE = ?";
		Object[] parametrosSql = new Object[] {idCliente};
		try {
			cliente = jdbcTemplate.queryForObject(sql, parametrosSql, new ClienteMapper());
		} catch (Exception e) {
			throw e;
		}
		return cliente;
	}

	public List<Cliente> findAll() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes";
		try {
			clientes = jdbcTemplate.query(sql, new ClienteMapper());
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}

}
