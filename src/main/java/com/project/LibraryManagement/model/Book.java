package com.project.LibraryManagement.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String genre;
    private String isbn;

    @Embedded
    @ElementCollection
    @CollectionTable(name="publisher",joinColumns = @JoinColumn(name="book_id"))
    private List<Publisher> publishers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "authorId")
    private List<Author> author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}

