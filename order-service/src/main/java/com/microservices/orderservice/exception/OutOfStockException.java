package com.microservices.orderservice.exception;

public class OutOfStockException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Out of stock!";

    public OutOfStockException() {
        super(ERROR_MESSAGE);
    }

}
