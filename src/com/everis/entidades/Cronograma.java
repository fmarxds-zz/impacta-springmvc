package com.everis.entidades;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.everis.enumeracoes.Concluido;

import lombok.Data;

@Data
public class Cronograma {
	
	private int idCronograma;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date data;
	private int duracao;
	private String descricao;
	private Concluido concluido;
	private Projeto projeto;
	
	public int getIdProjeto() {
		return this.projeto.getIdProjeto();
	}

	public java.sql.Date getDataSql() {
		return new java.sql.Date(this.data.getTime());
	}
	
	public String getConcluidoSql() {
		return this.concluido.toString();
	}
}
