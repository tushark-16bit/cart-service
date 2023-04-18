package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.Cart;

import java.util.UUID;

public interface UpdateCartPort {

    Cart persistCart(Cart cart);

    void deleteCart(UUID cartId);
}
