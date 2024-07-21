package com.guettafa.cachingwithspring.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound() {
        super("Customer cannot be found");
    }
}
