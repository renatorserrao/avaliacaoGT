package br.com.cadastro.util;

public enum Mensagem{
	
		SUCESSO(0,"Sucesso"),
		ALTERADO(6,"Alterado com Sucesso"),
		ERRO(1,"Erro"),
		ERRO_INTEGRIDADE(2,"Integridade"),
		ERRO_CPF_CADASTRADO(3,"CPF Já cadastrado"),
		ERRO_NAO_ENCONTRADA(4,"Pessoa não encontrada"),
		ERRO_SITUACAO_SERVIDOR(5,"Servidor Inativo");

	  private Integer id;
	  private String msg;
	
	  private Mensagem(Integer id, String tipo) {
	    this.id = id;
	    this.msg = tipo;
	  }
	
	  public String getMsg() {
	    return msg;
	  }
	
	  public Integer getId() {
	    return id;
	  }
	
	  public static boolean contains(String msg) {
	    for (Mensagem ad : Mensagem.values()) {
	      if (msg.equals(ad.getMsg()))
	        return true;
	    }
	    return false;
	  }
	
	  public String toString() {
	    return this.msg;
	  }
}
	
	
