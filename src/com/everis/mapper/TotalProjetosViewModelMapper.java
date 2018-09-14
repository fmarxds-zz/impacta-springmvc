package com.everis.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.everis.viewmodels.TotalProjetosViewModel;

public class TotalProjetosViewModelMapper implements RowMapper<TotalProjetosViewModel> {

	@Override
	public TotalProjetosViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalProjetosViewModel viewModel = new TotalProjetosViewModel();
		viewModel.setCliente(rs.getString("CLIENTE"));
		viewModel.setQuantidade(rs.getInt("QUANT"));
		viewModel.setTotal(rs.getDouble("TOTAL"));
		return viewModel;
	}
	
}
