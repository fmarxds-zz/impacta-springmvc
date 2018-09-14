package com.everis.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.everis.entidades.Projeto;

public class ProjetoMapper implements RowMapper<Projeto> {

	@Override
	public Projeto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Projeto projeto = new Projeto();
		projeto.setIdProjeto(rs.getInt("IDPROJETO"));
		projeto.setDocumento(rs.getString("DOCUMENTO"));
		projeto.setDescricao(rs.getString("DESCRICAO"));
		projeto.setDuracao(rs.getInt("DURACAO"));
		projeto.setValor(rs.getDouble("VALOR"));
		return projeto;
	}

}
