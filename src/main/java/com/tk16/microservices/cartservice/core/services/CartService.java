package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

    @Autowired CartDatabase cartDatabase;

    // get cart
    public Cart getCartById(UUID id) {
        return cartDatabase.getCartById(id);
    }

    // delete cart

    // create cart
    public UUID createCart() {
        return cartDatabase.save(new Cart()).getCartId();
    }

    // add book to cart
    // - get card from cart db
    // - get book from book client service
    // - add book as cart item to cart
    // - save new cart item
    // - @transactional
    // remove book from cart


    // get cart items in cart
}
