
package com.example.eleazer.desafioglobo.modelos;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Conteudo implements Serializable {

    @SerializedName("autores")
    private List<String> autores = null;
    @SerializedName("informePublicitario")
    private Boolean informePublicitario;
    @SerializedName("subTitulo")
    private String subTitulo;
    @SerializedName("texto")
    private String texto;
    @SerializedName("videos")
    private List<Object> videos = null;
    @SerializedName("atualizadoEm")
    private String atualizadoEm;
    @SerializedName("id")
    private Integer id;
    @SerializedName("publicadoEm")
    private String publicadoEm;
    @SerializedName("secao")
    private Secao secao;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("url")
    private String url;
    @SerializedName("urlOriginal")
    private String urlOriginal;
    @SerializedName("imagens")
    private List<Imagen> imagens = null;

    @SerializedName("autores")
    public List<String> getAutores() {
        return autores;
    }

    @SerializedName("autores")
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    @SerializedName("informePublicitario")
    public Boolean getInformePublicitario() {
        return informePublicitario;
    }

    @SerializedName("informePublicitario")
    public void setInformePublicitario(Boolean informePublicitario) {
        this.informePublicitario = informePublicitario;
    }

    @SerializedName("subTitulo")
    public String getSubTitulo() {
        return subTitulo;
    }

    @SerializedName("subTitulo")
    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    @SerializedName("texto")
    public String getTexto() {
        return texto;
    }

    @SerializedName("texto")
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @SerializedName("videos")
    public List<Object> getVideos() {
        return videos;
    }

    @SerializedName("videos")
    public void setVideos(List<Object> videos) {
        this.videos = videos;
    }

    @SerializedName("atualizadoEm")
    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    @SerializedName("atualizadoEm")
    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("publicadoEm")
    public String getPublicadoEm() {
        return publicadoEm;
    }

    @SerializedName("publicadoEm")
    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    @SerializedName("secao")
    public Secao getSecao() {
        return secao;
    }

    @SerializedName("secao")
    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    @SerializedName("tipo")
    public String getTipo() {
        return tipo;
    }

    @SerializedName("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @SerializedName("titulo")
    public String getTitulo() {
        return titulo;
    }

    @SerializedName("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @SerializedName("url")
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("urlOriginal")
    public String getUrlOriginal() {
        return urlOriginal;
    }

    @SerializedName("urlOriginal")
    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    @SerializedName("imagens")
    public List<Imagen> getImagens() {
        return imagens;
    }

    @SerializedName("imagens")
    public void setImagens(List<Imagen> imagens) {
        this.imagens = imagens;
    }

}
