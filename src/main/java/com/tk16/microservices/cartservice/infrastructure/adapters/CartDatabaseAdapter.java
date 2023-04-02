package com.tk16.microservices.cartservice.infrastructure.adapters;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.ports.database.CartDatabase;
import com.tk16.microservices.cartservice.infrastructure.repositories.CartRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component public class CartDatabaseAdapter implements CartDatabase {

    CartRepository repository;

    public CartDatabaseAdapter(CartRepository repository) {
        this.repository = repository;
    }

    // get All carts
    @Override public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    // get cart
    @Override public Cart getCartById(UUID cartId) {
        return repository.findById(cartId).orElse(null);
    }

    // delete cart
    @Override public void deleteCartById(UUID cartId) {}

    // create cart

    @Override public Cart save(Cart cart) {
        return repository.save(cart);
    }


    // add book to cart

    // remove book from cart
}
