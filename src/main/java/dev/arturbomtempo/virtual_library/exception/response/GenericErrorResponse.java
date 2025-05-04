package dev.arturbomtempo.virtual_library.exception.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GenericErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String message;
}