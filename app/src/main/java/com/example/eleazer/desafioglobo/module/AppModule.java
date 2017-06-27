package com.example.eleazer.desafioglobo.module;

import com.example.eleazer.desafiomobfiq.service.AppService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {


    private String url;

    @Provides
    public AppService getChatService() {

        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://desafio.mobfiq.com.br/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AppService appService = retrofit.create(AppService.class);

        return appService;
    }

    @Provides
    public EventBus getEventBus() {
        return EventBus.builder().build();
    }
}
