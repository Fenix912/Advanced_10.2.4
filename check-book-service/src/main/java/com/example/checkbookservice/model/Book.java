package com.example.checkbookservice.model;


import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private String description;
    private String status;
    private double price;

    public Book(Long id, String name, String description, String status, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }
}
