package com.banco.api.exception;

public class SaldoNoDisponibleException extends RuntimeException{
    public SaldoNoDisponibleException(String message) {
        super(message);
    }
}
