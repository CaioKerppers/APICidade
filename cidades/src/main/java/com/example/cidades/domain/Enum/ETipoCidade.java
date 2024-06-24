package com.example.cidades.domain.Enum;

public enum ETipoCidade {
    POPULACAO("População"),
    IDIOMA("Língua"),
    ANO_CRIACAO("Ano de Criação");

    private String valor;

    private ETipoCidade(String valor){
        this.valor = valor; 
    }

    public String getValor() {
        return valor;
    }
}
