package com.example.eleazer.desafioglobo.callback;

import com.example.eleazer.desafioglobo.MainActivity;
import com.example.eleazer.desafioglobo.event.FailureEvent;
import com.example.eleazer.desafioglobo.event.CarregaNoticiasEvent;
import com.example.eleazer.desafioglobo.modelos.Noticias;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OuvirNoticiasCallback implements Callback<List<Noticias>> {

    private MainActivity activity;
    private EventBus eventBus;

    public OuvirNoticiasCallback(EventBus eventBus, MainActivity activity) {
        this.activity = activity;
        this.eventBus = eventBus;
    }

    @Override
    public void onResponse(Call<List<Noticias>> call, Response<List<Noticias>> response) {
        if(response.isSuccessful()) {
            List<Noticias> noticias = response.body();

            eventBus.post(new CarregaNoticiasEvent(noticias));
        }

    }

    @Override
    public void onFailure(Call<List<Noticias>> call, Throwable t) {
        System.out.println(t.getMessage());
        eventBus.post(new FailureEvent());
    }
}