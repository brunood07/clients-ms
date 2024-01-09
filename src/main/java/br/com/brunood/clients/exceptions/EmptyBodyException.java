package br.com.brunood.clients.exceptions;

public class EmptyBodyException extends RuntimeException {
    public EmptyBodyException() {
        super("Invalid Body");
    }
}
