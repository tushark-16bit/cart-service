package com.tk16.microservices.cart_service.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Cart {

    private UUID id;
    private UserDetails userDetails;
    private List<CartItem> items;
    private BigDecimal total;

    public Cart() {
    }

    public Cart(UserDetails userDetails, List<CartItem> items,
                BigDecimal total) {
        this.id = UUID.randomUUID();
        this.userDetails = userDetails;
        this.items = items;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(
            UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(
            List<CartItem> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return getItems().stream()
                .map(cartItem ->
                        cartItem.getBookDetails().getPrice())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public static class UserDetails {
        UUID userId;
        String email;

        public UserDetails() {
        }

        public UserDetails(UUID userId, String email) {
            this.userId = userId;
            this.email = email;
        }

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
