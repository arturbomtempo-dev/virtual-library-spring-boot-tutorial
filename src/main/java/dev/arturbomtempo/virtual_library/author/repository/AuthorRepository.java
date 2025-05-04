package dev.arturbomtempo.virtual_library.author.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.arturbomtempo.virtual_library.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Optional<Author> findById(UUID id);
}
