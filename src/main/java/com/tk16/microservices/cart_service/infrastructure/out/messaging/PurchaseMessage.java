package com.tk16.microservices.cart_service.infrastructure.out.messaging;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PurchaseMessage {

    private UUID cartId;
    private BigDecimal amount;
    private UUID userId;
    private String email;
    private List<String> itemsBought;

    public PurchaseMessage() {
    }

    public PurchaseMessage(UUID cartId, BigDecimal amount, UUID userId,
                           String email, List<String> itemsBought) {
        this.cartId = cartId;
        this.amount = amount;
        this.userId = userId;
        this.email = email;
        this.itemsBought = itemsBought;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public List<String> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(List<String> itemsBought) {
        this.itemsBought = itemsBought;
    }
}
