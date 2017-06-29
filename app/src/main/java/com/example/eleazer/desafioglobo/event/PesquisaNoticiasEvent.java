package com.example.eleazer.desafioglobo.event;


import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.List;

public class PesquisaNoticiasEvent {

    public List<Noticias> noticias;

    public PesquisaNoticiasEvent(List<Noticias> noticias) {
        this.noticias = noticias;
    }

    public PesquisaNoticiasEvent() {

    }
}
