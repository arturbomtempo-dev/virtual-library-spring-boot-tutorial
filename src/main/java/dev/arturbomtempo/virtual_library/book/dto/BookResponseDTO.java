package dev.arturbomtempo.virtual_library.book.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.arturbomtempo.virtual_library.author.model.Author;
import dev.arturbomtempo.virtual_library.book.model.Book;
import dev.arturbomtempo.virtual_library.book.model.enumeration.Category;

public record BookResponseDTO(
        UUID id,
        String title,
        Category category,
        List<String> authorsNames) {
    public BookResponseDTO(Book book) {
        this(book.getId(), book.getTitle(), book.getCategory(),
                book.getAuthors().stream().map(Author::getName).collect(Collectors.toList()));
    }
}