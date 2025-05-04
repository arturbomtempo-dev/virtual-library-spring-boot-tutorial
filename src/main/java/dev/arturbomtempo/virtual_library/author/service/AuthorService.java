package dev.arturbomtempo.virtual_library.author.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.arturbomtempo.virtual_library.author.dto.AuthorRequestDTO;
import dev.arturbomtempo.virtual_library.author.dto.AuthorResponseDTO;
import dev.arturbomtempo.virtual_library.author.model.Author;
import dev.arturbomtempo.virtual_library.author.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponseDTO create(AuthorRequestDTO dto) {
        Author author = new Author();

        author.setName(dto.name());
        author.setDescription(dto.description());

        return new AuthorResponseDTO(authorRepository.save(author));
    }

    public AuthorResponseDTO update(UUID id, AuthorRequestDTO dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found."));

        author.setName(dto.name());
        author.setDescription(dto.description());

        return new AuthorResponseDTO(authorRepository.save(author));
    }

    public List<AuthorResponseDTO> findAll() {
        return authorRepository.findAll().stream().map(AuthorResponseDTO::new).toList();
    }

    public AuthorResponseDTO findById(UUID id) {
        Author foundAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found."));
        return new AuthorResponseDTO(foundAuthor);
    }

    public void delete(UUID id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found.");
        }

        authorRepository.deleteById(id);
    }
}
