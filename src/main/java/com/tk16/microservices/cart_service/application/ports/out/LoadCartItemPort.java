package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.CartItem;

import java.util.List;
import java.util.UUID;

public interface LoadCartItemPort {

    CartItem readCartItem(UUID cartItemId);

    List<CartItem> loadCartItemsInCart(UUID cartId);
}
