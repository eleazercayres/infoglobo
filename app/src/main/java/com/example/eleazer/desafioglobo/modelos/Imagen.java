
package com.example.eleazer.desafioglobo.modelos;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Imagen implements Serializable {

    @SerializedName("autor")
    private String autor;
    @SerializedName("fonte")
    private String fonte;
    @SerializedName("legenda")
    private String legenda;
    @SerializedName("url")
    private String url;

    @SerializedName("autor")
    public String getAutor() {
        return autor;
    }

    @SerializedName("autor")
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @SerializedName("fonte")
    public String getFonte() {
        return fonte;
    }

    @SerializedName("fonte")
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @SerializedName("legenda")
    public String getLegenda() {
        return legenda;
    }

    @SerializedName("legenda")
    public void setLegenda(String legenda) {
        this.legenda = legenda;
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
