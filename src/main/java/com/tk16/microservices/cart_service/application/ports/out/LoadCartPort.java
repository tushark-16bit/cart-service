package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.Cart;

import java.util.List;
import java.util.UUID;

public interface LoadCartPort {

    Cart readCart(UUID id);

    List<Cart> readAllCarts();
}
