package com.tk16.microservices.cart_service.application.ports.in.models;

import java.util.UUID;

public class PurchaseCartCommand {

    UUID cartId;

    public PurchaseCartCommand() {
    }

    public PurchaseCartCommand(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }
}
