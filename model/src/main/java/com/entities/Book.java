package com.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String title;
    private String author;
    private String genre;
    private String isbn;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",  // Provide the actual name of the join table
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Book(long bookId, String title, String author, String genre, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    //Default constructor
    public Book() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

