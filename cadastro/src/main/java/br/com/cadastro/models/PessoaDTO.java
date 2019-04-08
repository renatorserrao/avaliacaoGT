package br.com.cadastro.models;

import com.google.gson.annotations.Expose;

public class PessoaDTO {
	
	@Expose
	private int idpessoa;
	@Expose
	private String nome;
	@Expose
	private String cpf;
	@Expose
	private String dtnascimento;
	@Expose
	private String peso;
	@Expose
	private String estadoDesc;
	@Expose
	private int idEstado;
	@Expose
	private int idRegiao;
	@Expose
	private Estado estado;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public int getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public int getIdRegiao() {
		return idRegiao;
	}
	public void setIdRegiao(int idRegiao) {
		this.idRegiao = idRegiao;
	}
	public String getEstadoDesc() {
		return estadoDesc;
	}
	public void setEstadoDesc(String estadoDesc) {
		this.estadoDesc = estadoDesc;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
