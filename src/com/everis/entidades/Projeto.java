package com.everis.entidades;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Projeto {

	private int idProjeto;
	private String documento;
	private String descricao;
	private int duracao;
	private double valor;
	private Cliente cliente;
	private Set<Cronograma> cronogramas = new HashSet<>();

	public int getIdCliente() {
		return this.cliente.getIdCliente();
	}

}
