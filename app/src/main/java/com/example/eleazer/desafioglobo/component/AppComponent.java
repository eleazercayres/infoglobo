package com.example.eleazer.desafioglobo.component;

import com.example.eleazer.desafiomobfiq.MainActivity;
import com.example.eleazer.desafiomobfiq.module.AppModule;

import dagger.Component;

@Component(modules=AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);

}
