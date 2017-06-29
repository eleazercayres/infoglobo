package com.example.eleazer.desafioglobo.event;


import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.List;

public class CarregaNoticiasEvent {

    public List<Noticias> noticias;

    public CarregaNoticiasEvent(List<Noticias> noticias) {
        this.noticias = noticias;
    }

    public CarregaNoticiasEvent() {

    }
}
