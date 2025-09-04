package com.example.bibliotecaIngSoftII.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    private String bookId;
    private String user;
    private String content;
    private boolean preview; // true = en vista previa, false = publicada

    public Review() {}

    public Review(String bookId, String user, String content, boolean preview) {
        this.bookId = bookId;
        this.user = user;
        this.content = content;
        this.preview = preview;
    }

    // getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean isPreview() { return preview; }
    public void setPreview(boolean preview) { this.preview = preview; }
}
