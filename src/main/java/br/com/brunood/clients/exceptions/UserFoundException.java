package br.com.brunood.clients.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("user already exists");
    }
}
