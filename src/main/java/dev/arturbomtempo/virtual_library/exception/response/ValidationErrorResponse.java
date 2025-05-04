package dev.arturbomtempo.virtual_library.exception.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ValidationErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String message;
    private final List<String> errors;
}
