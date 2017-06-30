package com.example.eleazer.desafioglobo.enumerator;

public enum ActivityEnum {

    CONTEUDO("conteudo"),
    TODOS("Todos");

    private String value;

    public String getValue() {
        return value;
    }
    private ActivityEnum(String value) {
        this.value = value;
    }
}
