package com.example.creationbookservice.model;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private String description;
    private String status;
    private double price;

    private Book(Long id, String name, String description, String status, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private String status = "unchecked";
        private double price;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(id, name, description, status, price);
        }
    }
}