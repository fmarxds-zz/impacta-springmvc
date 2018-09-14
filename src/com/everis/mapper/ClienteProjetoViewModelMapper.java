package com.everis.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.everis.viewmodels.ClienteProjetoViewModel;

public class ClienteProjetoViewModelMapper implements RowMapper<ClienteProjetoViewModel> {

	@Override
	public ClienteProjetoViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteProjetoViewModel viewModel = new ClienteProjetoViewModel();
		viewModel.setCliente(rs.getString("CLIENTE"));
		viewModel.setDocumento(rs.getString("DOCUMENTO"));
		viewModel.setDescricao(rs.getString("DESCRICAO"));
		viewModel.setValor(rs.getDouble("VALOR"));
		return viewModel;
	}

}
