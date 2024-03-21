package com.avaliacao.web.avaliacao.vo;

public class CadastroVO {
	
	private String nomeUsuario;
	private String senha;

	public CadastroVO() {}

	public CadastroVO(String nomeUsuario, String senha) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
