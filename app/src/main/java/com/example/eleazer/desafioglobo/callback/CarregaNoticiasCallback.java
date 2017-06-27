package com.example.eleazer.desafioglobo.callback;

import com.example.eleazer.desafioglobo.event.NoticiasEvent;
import com.example.eleazer.desafioglobo.modelos.Noticias;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarregaNoticiasCallback implements Callback<List<Noticias>> {

    private EventBus eventBus;

    public CarregaNoticiasCallback(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onResponse(Call<List<Noticias>> call, Response<List<Noticias>> response) {
        if(response.isSuccessful()) {
            List<Noticias> noticiasList = response.body();

            eventBus.post(new NoticiasEvent(noticiasList));
        }
    }

    @Override
    public void onFailure(Call<List<Noticias>> call, Throwable t) {
        System.out.println(t.getMessage());
    }
}
