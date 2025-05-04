package dev.arturbomtempo.virtual_library.author.dto;

import java.util.UUID;

import dev.arturbomtempo.virtual_library.author.model.Author;

public record AuthorResponseDTO(UUID id, String name, String description) {

    public AuthorResponseDTO(Author author) {
        this(author.getId(), author.getName(), author.getDescription());
    }
}
