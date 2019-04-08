package br.com.cadastro.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estado {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("sigla")
@Expose
private String sigla;
@SerializedName("nome")
@Expose
private String nome;
@SerializedName("regiao")
@Expose
private Regiao regiao;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getSigla() {
return sigla;
}

public void setSigla(String sigla) {
this.sigla = sigla;
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public Regiao getRegiao() {
return regiao;
}

public void setRegiao(Regiao regiao) {
this.regiao = regiao;
}

}