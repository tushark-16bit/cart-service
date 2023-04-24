package com.tk16.microservices.cart_service.infrastructure.out.web;

import java.math.BigDecimal;

public class BookDto {

    private BookId bookId;

    private String title;

    private String description;

    private String author;

    private String genre;

    private double rating;
    private BigDecimal price;

    public static class BookId {
        long bookId;

        public BookId() {
        }

        public BookId(long bookId) {
            this.bookId = bookId;
        }

        public long getBookId() {
            return bookId;
        }

        public void setBookId(long bookId) {
            this.bookId = bookId;
        }
    }

    public BookDto(
            BookId bookId,
            String title,
            String description,
            String author,
            String genre,
            double rating,
            BigDecimal price) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    public BookDto() {
    }

    public BookId getBookId() {
        return bookId;
    }

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{"
                + "bookId="
                + bookId
                + ", title='"
                + title
                + '\''
                + ", description='"
                + description
                + '\''
                + ", author='"
                + author
                + '\''
                + ", genre='"
                + genre
                + '\''
                + ", rating="
                + rating
                + ", price="
                + price
                + '}';
    }
}
