package com.livraria.livrariagerenciamentolivros.exception;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException () {

    }

    public LivroNotFoundException(String message) {
        super(message);
    }
    
}
