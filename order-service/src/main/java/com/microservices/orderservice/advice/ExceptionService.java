package com.microservices.orderservice.advice;

import com.microservices.orderservice.exception.OutOfStockException;
import com.microservices.orderservice.model.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(OutOfStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorObject outOfStockException(OutOfStockException outOfStockException) {
        return new ErrorObject(OutOfStockException.class.getSimpleName(), outOfStockException.getMessage());
    }
}
