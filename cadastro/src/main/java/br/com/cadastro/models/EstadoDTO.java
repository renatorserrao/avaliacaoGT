package br.com.cadastro.models;

import com.google.gson.annotations.Expose;

public class EstadoDTO {
	
	@Expose
	private int id;
	@Expose
	private String nome;
	@Expose
	private String sigla;
	@Expose
	private String idestadoregiao;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getIdestadoregiao() {
		return idestadoregiao;
	}
	public void setIdestadoregiao(String idestadoregiao) {
		this.idestadoregiao = idestadoregiao;
	}
	
}
