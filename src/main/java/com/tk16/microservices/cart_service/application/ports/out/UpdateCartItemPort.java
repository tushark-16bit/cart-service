package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.CartItem;

import java.util.UUID;

public interface UpdateCartItemPort {

    CartItem persistCartItemToCart(UUID cartId, CartItem cartItem);

    void deleteCartItem(UUID cartItemId);
}
