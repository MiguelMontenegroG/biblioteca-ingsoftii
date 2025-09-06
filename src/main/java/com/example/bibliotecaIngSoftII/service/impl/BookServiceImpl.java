package com.example.bibliotecaIngSoftII.service.impl;

import com.example.bibliotecaIngSoftII.model.Book;
import com.example.bibliotecaIngSoftII.repository.BookRepository;
import com.example.bibliotecaIngSoftII.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchSimple(String query) {
        return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(query, query);
    }

    @Override
    public List<Book> searchAdvanced(String author, String title, String isbn) {
        return bookRepository.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCaseAndIsbnContainingIgnoreCase(
                author != null ? author : "",
                title != null ? title : "",
                isbn != null ? isbn : ""
        );
    }


    @Override
    public Book rateBook(String bookId, int rating) {
        if (rating < 1 || rating > 5) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La calificación debe estar entre 1 y 5");
        }

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));

        if (book.getRatings() == null) {
            book.setRatings(new ArrayList<>());
        }
        book.getRatings().add(rating);
        return bookRepository.save(book);
    }

}
