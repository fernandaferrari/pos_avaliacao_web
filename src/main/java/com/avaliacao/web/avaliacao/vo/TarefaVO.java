package com.avaliacao.web.avaliacao.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.avaliacao.web.avaliacao.model.Tarefa;

public class TarefaVO {
	
	public Long id;
	public String nome;
	public String descricao;
	public String dataInicio;
	
	public TarefaVO() {
		super();
	}

	public TarefaVO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.nome = tarefa.getNome();
		this.descricao = tarefa.getDescricao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatter.format(tarefa.getDataInicio());
		this.dataInicio = dataFormatada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
