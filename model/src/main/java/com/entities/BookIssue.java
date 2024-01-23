package com.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BookIssue {

    @Id
    private int id;
    //map this to user tabl

    // Map User and bookissue one to many
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
    private LocalDate issueDate;
    //how to create return date ?? have to discuss with team
    private LocalDate expireDate;


}
