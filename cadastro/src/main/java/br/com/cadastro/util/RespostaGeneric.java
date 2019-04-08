package br.com.cadastro.util;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;


/**
 * @author Thiago Sarmento
 * 
 * */

@XmlRootElement
public class RespostaGeneric<T> {
	
	@Expose
	private Integer codigo;
	@Expose
	private String mensagem;
	@Expose
	private T objeto;
	
	public RespostaGeneric(){
		
	}
	
	public RespostaGeneric(Integer codigo, String mensagem, T objeto) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.objeto = objeto;
		
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
}
