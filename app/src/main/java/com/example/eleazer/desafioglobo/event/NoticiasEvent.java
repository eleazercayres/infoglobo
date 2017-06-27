package com.example.eleazer.desafioglobo.event;


import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.List;

public class NoticiasEvent {

    public List<Noticias> noticias;

    public NoticiasEvent(List<Noticias> noticias) {
        this.noticias = noticias;
    }

    public NoticiasEvent() {

    }
}
