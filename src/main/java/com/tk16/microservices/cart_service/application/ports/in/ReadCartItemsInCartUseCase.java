package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.ReadCartQuery;
import com.tk16.microservices.cart_service.domain.CartItem;

import java.util.List;

public interface ReadCartItemsInCartUseCase {

    List<CartItem> readAllCartItemsInCart(ReadCartQuery query);
}
