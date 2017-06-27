
package com.example.eleazer.desafioglobo.modelos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Secao implements Serializable {

    @SerializedName("nome")
    private String nome;
    @SerializedName("url")
    private String url;

    @SerializedName("nome")
    public String getNome() {
        return nome;
    }

    @SerializedName("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @SerializedName("url")
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
