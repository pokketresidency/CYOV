package com.cyov.marketplace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Response<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    private final String status;
    private final String message;
    private final T data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Response(final String status, final String message, final T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
