package com.example.eleazer.desafioglobo.service;

import com.example.eleazer.desafioglobo.modelos.Noticias;
import com.example.eleazer.desafiomobfiq.modelos.Categories;
import com.example.eleazer.desafiomobfiq.modelos.JsonRootBean;
import com.example.eleazer.desafiomobfiq.modelos.Query;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppService {

    @GET("/StorePreference/CategoryTree")
    Call<SerializedName> ouvirNoticias();
}
