package com.example.eleazer.desafioglobo.enumerator;

public enum ActivityEnum {

    CONTEUDO("conteudo");

    private String value;

    public String getValue() {
        return value;
    }
    private ActivityEnum(String value) {
        this.value = value;
    }
}
