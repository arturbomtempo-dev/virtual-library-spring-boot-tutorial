package dev.arturbomtempo.virtual_library.book.controller;

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

import dev.arturbomtempo.virtual_library.book.dto.BookRequestDTO;
import dev.arturbomtempo.virtual_library.book.dto.BookResponseDTO;
import dev.arturbomtempo.virtual_library.book.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BookRequestDTO book) {
        bookService.create(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Book successfully registered.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid BookRequestDTO book) {
        bookService.update(id, book);
        return ResponseEntity.ok("Book data successfully updated.");
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.ok("Book successfully deleted.");
    }
}
