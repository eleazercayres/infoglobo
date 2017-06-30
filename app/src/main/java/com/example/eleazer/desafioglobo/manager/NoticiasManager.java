package com.example.eleazer.desafioglobo.manager;

import com.example.eleazer.desafioglobo.enumerator.ActivityEnum;
import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NoticiasManager {

    public static final int DESTAQUE = 0;
    public static final int CONTEUDOS = 0;

    private List<Noticias> noticiasList;

    private Conteudo destaque;
    private String urlImageDestaque;
    private List<String> secoes;
    private Map<String, String> secaoMap;
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

            carregaDestaque();

            Iterator<Conteudo> iterator = conteudos.iterator();

            while (iterator.hasNext()) {

                Conteudo conteudo = iterator.next();

                if (validarImagem(iterator, conteudo)) continue;

                if (validarAutor(iterator, conteudo)) continue;

                if (validarTexto(iterator, conteudo)) continue;

                validarSecao(conteudo);

                secoes =  new ArrayList(secaoMap.keySet());
            }
        }
    }

    private void validarSecao(Conteudo conteudo) {
        if (secaoMap
                == null) {
            secaoMap = new HashMap<>();
        }
        secaoMap.put(conteudo.getSecao().getNome(), conteudo.getSecao().getNome());
    }

    private boolean validarTexto(Iterator<Conteudo> i, Conteudo conteudo) {
        if(conteudo.getTexto() == null) {
            i.remove();
            return true;
        }
        return false;
    }

    private boolean validarAutor(Iterator<Conteudo> i, Conteudo conteudo) {
        if (conteudo.getAutores()== null || conteudo.getAutores() != null && conteudo.getAutores().size() == 0) {
            i.remove();
            return true;
        }
        return false;
    }

    private boolean validarImagem(Iterator<Conteudo> i, Conteudo conteudo) {
        if (conteudo.getImagens() != null && conteudo.getImagens().size()<=0){
            i.remove();
            return true;
        }
        return false;
    }

    private void carregaDestaque() {

        destaque = conteudos.get(DESTAQUE);
        if (carregaImagemDestaque(destaque)){
            conteudos.remove(destaque);
        } else {
            conteudos.remove(destaque);
            carregaDestaque();
        }
    }

    private boolean carregaImagemDestaque(Conteudo destaque) {

        boolean result = false;
        if (getDestaque() != null && getDestaque().getImagens() != null
                && getDestaque().getImagens().get(0) != null
                && getDestaque().getImagens().get(0).getUrl() != null){

            urlImageDestaque = getDestaque().getImagens().get(0).getUrl();
            result = true;
        }

        return result;
    }

    public List<String> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<String> secoes) {
        this.secoes = secoes;
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

    public String getUrlImageDestaque() {
        return urlImageDestaque;
    }

    public void setUrlImageDestaque(String urlImageDestaque) {
        this.urlImageDestaque = urlImageDestaque;
    }

    public List<Conteudo> carregaConteudoFiltro(String nameMenu) {

        List<Conteudo> conteudoFilter = new ArrayList<>();
        Iterator<Conteudo> iterator = conteudos.iterator();

        if (nameMenu.equalsIgnoreCase(ActivityEnum.TODOS.getValue())) {
            conteudoFilter = conteudos;
        } else {
            while (iterator.hasNext()) {
                Conteudo conteudo = iterator.next();
                if (conteudo.getSecao().getNome().equalsIgnoreCase(nameMenu)) {
                    conteudoFilter.add(conteudo);
                }
            }
        }
        return conteudoFilter;
    }
}
