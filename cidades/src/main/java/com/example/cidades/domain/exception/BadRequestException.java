package com.example.cidades.domain.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String mensagem){
        super(mensagem);
    }
    
}
