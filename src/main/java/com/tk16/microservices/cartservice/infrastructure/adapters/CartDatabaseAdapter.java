package com.tk16.microservices.cartservice.infrastructure.adapters;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import com.tk16.microservices.cartservice.infrastructure.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartDatabaseAdapter implements CartDatabase {

    @Autowired CartRepository repository;

    // get cart
    public Cart getCartById(UUID cartId) {
        return repository.findById(cartId).orElse(null);
    }

    // delete cart

    // create cart

    @Override public Cart save(Cart cart) {
        return repository.save(cart);
    }


    // add book to cart

    // remove book from cart
}
