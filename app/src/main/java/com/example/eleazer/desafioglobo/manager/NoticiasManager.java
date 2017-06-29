package com.example.eleazer.desafioglobo.manager;

import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.example.eleazer.desafioglobo.modelos.Noticias;
import com.example.eleazer.desafioglobo.modelos.Secao;

import java.util.ArrayList;
import java.util.List;

public class NoticiasManager {

    public static final int DESTAQUE = 0;
    public static final int CONTEUDOS = 0;

    private List<Noticias> noticiasList;
    private Conteudo destaque;
    private List<Secao> secoes;
    private List<Conteudo> conteudos;

    public NoticiasManager(List<Noticias> noticiasList) {
        this.noticiasList = noticiasList;
        if (noticiasList != null){
            carregaNoticias();
        }
    }

    private void carregaNoticias() {

        if (noticiasList != null && noticiasList.size() > 0) {
            conteudos = noticiasList.get(CONTEUDOS).getConteudos();
        }
        if (conteudos!= null && conteudos.size() > 0) {
            destaque = conteudos.get(DESTAQUE);
            conteudos.remove(destaque);
            for (Conteudo conteudo :conteudos) {
                if (secoes == null) {
                    secoes = new ArrayList<>();
                }
                secoes.add(conteudo.getSecao());
            }
        }
    }

    public Conteudo getDestaque() {
        return destaque;
    }

    public void setDestaque(Conteudo destaque) {
        this.destaque = destaque;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

}
