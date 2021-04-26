package com.exemplo.exception;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException() {
    }

    public SaldoInsuficienteException(String s) {
        super(s);
    }
}
