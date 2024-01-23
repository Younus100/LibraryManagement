package com.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String name;
    private String position;
    PASSWORD
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<BookIssue> bookIssues;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructors, getters, and setters

}