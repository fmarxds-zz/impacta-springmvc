package com.everis.entidades;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Cliente {

	private int idCliente;
	private String nome;
	private String email;
	private String telefone;
	private Usuario usuario;
	private Set<Projeto> projetos = new HashSet<>();

}
