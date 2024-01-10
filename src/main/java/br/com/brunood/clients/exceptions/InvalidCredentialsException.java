package br.com.brunood.clients.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("invalid credentials");
    }
}
