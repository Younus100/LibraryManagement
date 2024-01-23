package com.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private LocalDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, getters, and setters

}


