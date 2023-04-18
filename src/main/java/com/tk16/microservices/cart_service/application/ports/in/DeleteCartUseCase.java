package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.DeleteCartCommand;

public interface DeleteCartUseCase {

    void deleteCart(DeleteCartCommand deleteCartCommand);
}
