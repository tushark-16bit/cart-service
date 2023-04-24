package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.RemoveBookFromCartCommand;

public interface RemoveBookFromCartUseCase {

    void removeBookFromCart(RemoveBookFromCartCommand command);
}
