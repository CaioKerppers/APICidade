package com.example.cidades.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    
    public static String converterDateParaDataHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatador.format(data);
    }

    public static String formatarPopulacao(int populacao) {
        return String.format("%,d", populacao);
    }

    public static String formatarAnoCriacao(int ano) {
        return String.format("%04d", ano);
    }
}