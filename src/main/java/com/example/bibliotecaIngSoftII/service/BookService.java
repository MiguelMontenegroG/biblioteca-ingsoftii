package com.example.bibliotecaIngSoftII.service;

import com.example.bibliotecaIngSoftII.model.Book;
import java.util.List;

public interface BookService {
    List<Book> searchSimple(String query);
    List<Book> searchAdvanced(String author, String title, String isbn);
    Book rateBook(String bookId, int rating);
}