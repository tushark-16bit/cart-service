package com.tk16.microservices.cartservice.core.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class CartItem {

    @Id @GeneratedValue
    private long cartItemId;
    private long bookId;
    private String bookDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    private UUID cartId;
    private BigDecimal itemPrice;

    public CartItem() {
    }

    public CartItem(long bookId, String cartItemDescription, UUID cartId) {
        this.bookId = bookId;
        this.bookDescription = cartItemDescription;
        this.cartId = cartId;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
