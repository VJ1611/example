package com.cts.assignments.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private long bookId;

    private String title;

    private double price;

    private Integer volume;

    private LocalDate publishDate;


    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", publishDate=" + publishDate +
                '}';
    }
}
