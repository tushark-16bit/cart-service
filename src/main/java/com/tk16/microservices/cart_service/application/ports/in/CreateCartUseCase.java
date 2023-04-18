package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.CreateCartCommand;
import com.tk16.microservices.cart_service.domain.Cart;

public interface CreateCartUseCase {

    Cart createCart(CreateCartCommand createCartCommand);
}
