package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "available")
    private int available;

    public Book() {}

    public Book(String title, String author, String genre, double price, int quantity) {
        this.title     = title;
        this.author    = author;
        this.genre     = genre;
        this.price     = price;
        this.quantity  = quantity;
        this.available = quantity;
    }

    public int getId()                  { return id; }
    public void setId(int id)           { this.id = id; }
    public String getTitle()            { return title; }
    public void setTitle(String title)  { this.title = title; }
    public String getAuthor()           { return author; }
    public void setAuthor(String a)     { this.author = a; }
    public String getGenre()            { return genre; }
    public void setGenre(String g)      { this.genre = g; }
    public double getPrice()            { return price; }
    public void setPrice(double price)  { this.price = price; }
    public int getQuantity()            { return quantity; }
    public void setQuantity(int q)      { this.quantity = q; }
    public int getAvailable()           { return available; }
    public void setAvailable(int a)     { this.available = a; }

    @Override
    public String toString() {
        return String.format(
                "Book [id=%d, title=%s, author=%s, genre=%s, price=%.2f, qty=%d, available=%d]",
                id, title, author, genre, price, quantity, available);
    }
}