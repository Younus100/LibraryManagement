package com.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String authorName;
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    // Constructors, getters, and setters

    public Author(Long authorId, String authorName, String biography, List<Book> books) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.biography = biography;
        this.books = books;
    }

    public Author() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

