package dev.arturbomtempo.virtual_library.author.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arturbomtempo.virtual_library.author.dto.AuthorRequestDTO;
import dev.arturbomtempo.virtual_library.author.dto.AuthorResponseDTO;
import dev.arturbomtempo.virtual_library.author.service.AuthorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AuthorRequestDTO author) {
        authorService.create(author);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Author successfully registered.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
            @RequestBody @Valid AuthorRequestDTO author) {
        authorService.update(id, author);
        return ResponseEntity.ok("Author data successfully updated.");
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        authorService.delete(id);
        return ResponseEntity.ok("Author successfully deleted.");
    }
}
