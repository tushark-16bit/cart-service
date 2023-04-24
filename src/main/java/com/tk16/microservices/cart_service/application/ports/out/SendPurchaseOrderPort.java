package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.Cart;

public interface SendPurchaseOrderPort {

    // map to purchase order and if acknowledged/success, delete cart
    boolean sendPurchaseOrder(Cart cart);
}
