package com.everis.entidades;

import java.util.HashSet;
import java.util.Set;

import com.everis.enumeracoes.Niveis;

import lombok.Data;

@Data
public class Usuario {

	private String nome;
	private String senha;
	private Niveis nivel;
	private Set<Cliente> clientes = new HashSet<>();
	private Set<Prestador> prestadores = new HashSet<>();

}
