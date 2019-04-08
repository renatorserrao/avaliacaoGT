package br.com.cadastro.models;
// default package
// Generated 23/03/2019 22:09:20 by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
//@Table(name="PESSOA")
public class Pessoa implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpessoa;
	
	/*
	 * @ManyToOne
	 * @JoinColumn(name = "idestado")
	 *  private Estado estado;
	 */
	
	@NotEmpty(message = "{cpf.notempty}")
	private String cpf;
	
	@NotEmpty(message = "{nome.notempty}")
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt_BR", timezone = "GMT-03:00")
	private Date dtnascimento;
	private Float peso;
	
	@NotNull(message = "{idEstado.notnull}")
	private int idEstado;
	private int idRegiao;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int idpessoa, String cpf, String nome, Date dtnascimento, Float peso, int idEstado, int idRegiao) {
		super();
		this.idpessoa = idpessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.dtnascimento = dtnascimento;
		this.peso = peso;
		this.idEstado = idEstado;
		this.idRegiao = idRegiao;
	}

	public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getdtnascimento() {
		return dtnascimento;
	}

	public void setdtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
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
	
}
