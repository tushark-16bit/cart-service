package com.tk16.microservices.cartservice.core.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cartId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<CartItem> cartItems;
    @LastModifiedDate
    private LocalDateTime lastModifiedTime;
    private static final int CART_ITEM_CAPACITY = 10;

    public Cart() {
    }

    public Cart(UUID cartId, LocalDateTime lastModifiedTime) {
        this.cartId = cartId;
        this.lastModifiedTime = lastModifiedTime;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCartItems(
            List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public boolean isCartFull() {
        return CART_ITEM_CAPACITY<=cartItems.size();
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
