package com.example.eleazer.desafioglobo.component;


import com.example.eleazer.desafioglobo.activity.MainActivity;
import com.example.eleazer.desafioglobo.module.AppModule;

import dagger.Component;

@Component(modules=AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);

}
