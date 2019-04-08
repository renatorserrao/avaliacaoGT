package br.com.cadastro.util;

public class URL {

	public enum BUSCAR{
		
		ESTADOS("https://servicodados.ibge.gov.br/api/v1/localidades/estados");
		
		private String url;
		 private BUSCAR(String url) {
		    this.url = url;
		  
		  }
		  public String getURL() {
		    return url;
		  }  
		
	}
}
