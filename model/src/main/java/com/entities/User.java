package com.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public User(Long userId, String name, String address, String phone, String email) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }

    public Long getReaderId() {
        return userId;
    }

    public void setReaderId(Long readerId) {
        this.userId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
