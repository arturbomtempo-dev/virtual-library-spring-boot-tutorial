package dev.arturbomtempo.virtual_library.book.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.arturbomtempo.virtual_library.book.model.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

    Optional<Book> findById(UUID id);
}
