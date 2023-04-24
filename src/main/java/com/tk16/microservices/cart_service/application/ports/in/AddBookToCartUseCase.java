package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.AddBookToCartCommand;

public interface AddBookToCartUseCase {

    // the same book can be added into cart multiple times
    void addBookToCart(AddBookToCartCommand command);
}
