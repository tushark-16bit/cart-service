package com.tk16.microservices.cartservice.core.ports;

import com.tk16.microservices.cartservice.core.models.Cart;

import java.util.UUID;

public interface CartDatabase {

    Cart getCartById(UUID cartId);

    Cart save(Cart cart);

    void deleteCartById(UUID cartId);
}
