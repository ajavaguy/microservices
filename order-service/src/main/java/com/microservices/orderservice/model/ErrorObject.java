package com.microservices.orderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {
    @JsonProperty(value = "error_type")
    String errorType;

    @JsonProperty(value = "message")
    String message;


}
