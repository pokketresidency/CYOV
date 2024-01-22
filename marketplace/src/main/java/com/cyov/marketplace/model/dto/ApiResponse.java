package com.cyov.marketplace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<Type> {
    private Type data;
    private String status;
    private String errorCode;
    private String message;
}
