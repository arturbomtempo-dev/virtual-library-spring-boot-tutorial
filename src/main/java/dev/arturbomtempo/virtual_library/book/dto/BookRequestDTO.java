package dev.arturbomtempo.virtual_library.book.dto;

import java.util.List;
import java.util.UUID;

import dev.arturbomtempo.virtual_library.book.model.enumeration.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequestDTO(@NotBlank String title, @NotNull Category category, @NotEmpty List<UUID> authorsIds) {

}