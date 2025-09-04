package com.example.bibliotecaIngSoftII.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String title;
    private String author;
    private String isbn;

    private List<Integer> ratings; // lista de calificaciones 1-5

    public Book() {}

    public Book(String title, String author, String isbn, List<Integer> ratings) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.ratings = ratings;
    }

    public double getAverageRating() {
        if (ratings == null || ratings.isEmpty()) return 0.0;
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public List<Integer> getRatings() { return ratings; }
    public void setRatings(List<Integer> ratings) { this.ratings = ratings; }
}
