package com.br.davilnv.estoque.model;

public class Computador {
	private int id;
	private String nome;
	private String processador;
	private int memoria;
	private int hd;
	private int ssd;
	private String situacao;
	private String observacao;
	private String grupo;
	
	public Computador(int id, String nome, String processador, int memoria, int hd, int ssd, String situacao,
			String observacao, String grupo) {
		this.id = id;
		this.nome = nome;
		this.processador = processador;
		this.memoria = memoria;
		this.hd = hd;
		this.ssd = ssd;
		this.situacao = situacao;
		this.observacao = observacao;
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Computador [id=" + id + ", nome=" + nome + ", processador=" + processador + ", memoria=" + memoria
				+ ", hd=" + hd + ", ssd=" + ssd + ", situacao=" + situacao + ", observacao=" + observacao + ", grupo="
				+ grupo + "]";
	}
	
}
