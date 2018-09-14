package com.everis.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.everis.entidades.Cronograma;

public class CronogramaMapper implements RowMapper<Cronograma> {

	@Override
	public Cronograma mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
