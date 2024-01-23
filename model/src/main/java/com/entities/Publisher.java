package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publisher {
    //join publisher and book 1 to many
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    private String name;
    private String location;


    // Constructors, getters, and setters

    public Publisher(Long publisherId, String name, String location) {
        this.publisherId = publisherId;
        this.name = name;
        this.location = location;
    }

    public Publisher() {

    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}