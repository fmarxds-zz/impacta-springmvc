package com.everis.entidades;

import lombok.Data;

@Data
public class Prestador {

	private String documento;
	private String nome;
	private String email;
	private String telefone;
	private Usuario usuario;

}
