package com.tk16.microservices.cartservice.core.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cartItemId;
    private long bookId;
    private String bookDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
    private BigDecimal itemPrice;

    public CartItem() {
    }

    public CartItem(long bookId, String cartItemDescription, Cart cart,
                    BigDecimal bookPrice) {
        this.bookId = bookId;
        this.bookDescription = cartItemDescription;
        this.cart = cart;
        this.itemPrice = bookPrice;
    }

    public UUID getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(UUID cartItemId) {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
