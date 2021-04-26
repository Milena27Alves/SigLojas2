package com.exemplo.exception;

public class ItemExistenteException extends Exception{

    public ItemExistenteException() {
    }

    public ItemExistenteException(String message) {
        super(message);
    }
}
