package dev.arturbomtempo.virtual_library.author.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequestDTO(@NotBlank String name, String description) {

}
