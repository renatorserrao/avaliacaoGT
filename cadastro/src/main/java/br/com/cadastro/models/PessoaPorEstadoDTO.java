package br.com.cadastro.models;

import java.math.BigInteger;

import com.google.gson.annotations.Expose;

public class PessoaPorEstadoDTO {
	
	@Expose
	private Integer id;
	@Expose
	private BigInteger qtd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigInteger getQtd() {
		return qtd;
	}
	public void setQtd(BigInteger qtd) {
		this.qtd = qtd;
	}
	
	
	
}
