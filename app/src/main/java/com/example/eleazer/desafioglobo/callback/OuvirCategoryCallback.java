package com.example.eleazer.desafioglobo.callback;

import com.example.eleazer.desafiomobfiq.MainActivity;
import com.example.eleazer.desafiomobfiq.event.CategoryEvent;
import com.example.eleazer.desafiomobfiq.event.FailureEvent;
import com.example.eleazer.desafiomobfiq.modelos.Categories;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OuvirCategoryCallback implements Callback<Categories> {

    private MainActivity activity;
    private EventBus eventBus;

    public OuvirCategoryCallback(EventBus eventBus, MainActivity activity) {
        this.activity = activity;
        this.eventBus = eventBus;
    }

    @Override
    public void onResponse(Call<Categories> call, Response<Categories> response) {
        if(response.isSuccessful()) {
            Categories category = response.body();

            eventBus.post(new CategoryEvent(category));
        }

    }

    @Override
    public void onFailure(Call<Categories> call, Throwable t) {
        System.out.println(t.getMessage());
        eventBus.post(new FailureEvent());
    }
}