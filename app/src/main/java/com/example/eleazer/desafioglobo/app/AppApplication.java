package com.example.eleazer.desafioglobo.app;

import android.app.Application;

import com.example.eleazer.desafiomobfiq.component.AppComponent;
import com.example.eleazer.desafiomobfiq.component.DaggerAppComponent;

public class AppApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }
}