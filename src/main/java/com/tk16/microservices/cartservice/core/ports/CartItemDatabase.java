package com.tk16.microservices.cartservice.core.ports;

import com.tk16.microservices.cartservice.core.models.CartItem;

import java.util.UUID;

public interface CartItemDatabase {

    // save cart item
    CartItem save(CartItem item);

    // get cart item from id
    CartItem get(UUID id);

    // delete cart item by id, delete from cart


    // update cart item
}
