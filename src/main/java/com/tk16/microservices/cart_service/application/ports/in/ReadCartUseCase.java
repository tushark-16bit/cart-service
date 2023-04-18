package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.ReadCartQuery;
import com.tk16.microservices.cart_service.domain.Cart;

import java.util.List;

public interface ReadCartUseCase {

    Cart readCart(ReadCartQuery query);

    List<Cart> readAllCarts();
}
