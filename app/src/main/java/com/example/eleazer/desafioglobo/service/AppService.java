package com.example.eleazer.desafioglobo.service;

import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {

    @GET("/Infoglobo/desafio-apps/master/capa.json")
    Call<List<Noticias>> ouvirNoticias();
}
