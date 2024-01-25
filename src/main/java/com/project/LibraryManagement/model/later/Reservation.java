package com.project.LibraryManagement.model.later;

import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;


public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private LocalDateTime reservationDate;

//    @Enumerated(EnumType.STRING)
//    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, getters, and setters

}


