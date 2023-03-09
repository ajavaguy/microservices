package com.microservices.orderservice.advice;

import com.microservices.orderservice.exception.OutOfStockException;
import com.microservices.orderservice.model.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionService {

    @ResponseBody
    @ExceptionHandler(OutOfStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject outOfStockException(OutOfStockException outOfStockException) {
        return new ErrorObject(OutOfStockException.class.getSimpleName(), outOfStockException.getMessage());
    }
}
