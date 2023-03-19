package com.tk16.microservices.cartservice.core.ports;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemDatabase {

    // save cart item
    CartItem save(CartItem item);

    // get cart item from id
    CartItem get(UUID id);

    // delete cart item by id, delete from cart

    List<CartItem> findAll();

    // find all cartItems by cart
    List<CartItem> findAllByCart(Cart cart);

    List<CartItem> findAllByBookId(long bookId);
}
