package com.tk16.microservices.cart_service.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class CartItem {

    private UUID id;
    private BookDetails bookDetails;

    public CartItem() {
    }

    public CartItem(BookDetails bookDetails) {
        this.id = UUID.randomUUID();
        this.bookDetails = bookDetails;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(
            BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public static class BookDetails {
        private Long id;
        private String title;
        private String description;
        private BigDecimal price;

        public BookDetails() {
        }

        public BookDetails(Long id, String title, String description,
                           BigDecimal price) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override public String toString() {
            return "BookDetails{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
