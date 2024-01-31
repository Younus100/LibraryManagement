package com.project.LibraryManagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    @JsonIgnore
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;

}
