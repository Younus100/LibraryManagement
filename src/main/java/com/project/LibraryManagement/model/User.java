package com.project.LibraryManagement.model;

import com.project.LibraryManagement.model.later.Admin;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    @Embedded
    @ElementCollection
    @CollectionTable(name="address",joinColumns = @JoinColumn(name="userId"))
    private Address address;

    private LocalDateTime createdAt;

}
