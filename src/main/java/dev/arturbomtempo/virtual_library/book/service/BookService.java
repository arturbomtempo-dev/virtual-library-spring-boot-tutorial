package dev.arturbomtempo.virtual_library.book.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.arturbomtempo.virtual_library.author.model.Author;
import dev.arturbomtempo.virtual_library.author.repository.AuthorRepository;
import dev.arturbomtempo.virtual_library.book.dto.BookRequestDTO;
import dev.arturbomtempo.virtual_library.book.dto.BookResponseDTO;
import dev.arturbomtempo.virtual_library.book.model.Book;
import dev.arturbomtempo.virtual_library.book.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookResponseDTO create(BookRequestDTO dto) {
        List<Author> authors = authorRepository.findAllById(dto.authorsIds());

        if (authors.isEmpty()) {
            throw new RuntimeException("No valid authors found.");
        }

        Book book = new Book();

        book.setTitle(dto.title());
        book.setCategory(dto.category());
        book.setAuthors(authors);

        return new BookResponseDTO(bookRepository.save(book));
    }

    public BookResponseDTO update(UUID id, BookRequestDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found."));

        List<Author> authors = authorRepository.findAllById(dto.authorsIds());

        if (authors.isEmpty()) {
            throw new RuntimeException("No valid authors found.");
        }

        book.setTitle(dto.title());
        book.setCategory(dto.category());
        book.setAuthors(authors);

        return new BookResponseDTO(bookRepository.save(book));
    }

    public List<BookResponseDTO> findAll() {
        return bookRepository.findAll().stream().map(BookResponseDTO::new).toList();
    }

    public BookResponseDTO findById(UUID id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found."));
        return new BookResponseDTO(foundBook);
    }

    public void delete(UUID id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found.");
        }

        bookRepository.deleteById(id);
    }
}
