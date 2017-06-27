
package com.example.eleazer.desafioglobo.modelos;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Noticias implements Serializable {

    @SerializedName("conteudos")
    private List<Conteudo> conteudos = null;
    @SerializedName("produto")
    private String produto;

    @SerializedName("conteudos")
    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    @SerializedName("conteudos")
    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @SerializedName("produto")
    public String getProduto() {
        return produto;
    }

    @SerializedName("produto")
    public void setProduto(String produto) {
        this.produto = produto;
    }

}
