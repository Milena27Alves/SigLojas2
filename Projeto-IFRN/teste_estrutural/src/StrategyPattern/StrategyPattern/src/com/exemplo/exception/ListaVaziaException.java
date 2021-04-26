package com.exemplo.exception;

public class ListaVaziaException extends Exception {
    public ListaVaziaException() {
    }

    public ListaVaziaException(String message) {
        super(message);
    }
}
