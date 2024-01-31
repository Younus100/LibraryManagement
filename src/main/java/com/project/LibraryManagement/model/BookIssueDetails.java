package com.project.LibraryManagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class BookIssueDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookIssue_id",nullable = false)
    @JsonIgnore
    private BookIssue  bookIssue;

    @OneToOne
    private Book book;

    private LocalDateTime issueTime;

    private LocalDate expiryTime;


}
