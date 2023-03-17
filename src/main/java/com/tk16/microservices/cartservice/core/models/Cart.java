package com.tk16.microservices.cartservice.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Cart {

    @Id
    private UUID cartId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    @JsonIgnore
    private List<CartItem> cartItems;
    private LocalDateTime lastModifiedTime;
    private static final int CART_ITEM_CAPACITY = 10;

    public Cart() {
        this.cartId = UUID.randomUUID();
        this.lastModifiedTime = LocalDateTime.now();
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

    public void updateLastModifiedTime() {
        this.lastModifiedTime = LocalDateTime.now();
    }
}
