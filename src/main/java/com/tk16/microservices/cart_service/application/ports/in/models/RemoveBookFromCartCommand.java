package com.tk16.microservices.cart_service.application.ports.in.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class RemoveBookFromCartCommand {

    @NotNull
    UUID cartId;
    @NotNull @Positive
    Long bookId;

    public RemoveBookFromCartCommand() {
    }

    public RemoveBookFromCartCommand(UUID cartId, Long bookId) {
        this.cartId = cartId;
        this.bookId = bookId;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
