package com.example.example.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String errorMessage;
}
