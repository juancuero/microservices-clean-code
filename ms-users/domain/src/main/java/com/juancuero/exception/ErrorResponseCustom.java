package com.juancuero.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponseCustom {

    private String message;

    private LocalDateTime timestamp;

    public ErrorResponseCustom(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
