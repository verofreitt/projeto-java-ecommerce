package com.ecommerce.model;

public class Cliente {
    private String nome;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}