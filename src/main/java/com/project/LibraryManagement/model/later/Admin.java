package com.project.LibraryManagement.model.later;

import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.User;
import jakarta.persistence.*;

import java.util.List;

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String name;
    private String position;
//    PASSWORD
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<BookIssue> bookIssues;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructors, getters, and setters

}