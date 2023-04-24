package com.tk16.microservices.cart_service.application.ports.in;

import com.tk16.microservices.cart_service.application.ports.in.models.PurchaseCartCommand;

public interface PurchaseCartUseCase {

    void purchaseCart(PurchaseCartCommand command);
}
