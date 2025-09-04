package com.example.bibliotecaIngSoftII.repository;

import com.example.bibliotecaIngSoftII.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);
    List<Book> findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCaseAndIsbnContainingIgnoreCase(String author, String title, String isbn);
}
