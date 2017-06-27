package com.example.eleazer.desafioglobo.event;


import com.example.eleazer.desafiomobfiq.modelos.JsonRootBean;

public class ProductEvent {

    public JsonRootBean products;

    public ProductEvent(JsonRootBean category) {
        this.products = category;
    }

    public ProductEvent() {

    }
}
