package com.tk16.microservices.cartservice.infrastructure.adapters;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.database.CartItemDatabase;
import com.tk16.microservices.cartservice.infrastructure.repositories.CartItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CartItemDatabaseAdapter implements CartItemDatabase {

    CartItemRepository repository;

    public CartItemDatabaseAdapter(CartItemRepository repository) {
        this.repository = repository;
    }

    @Override public CartItem save(CartItem item) {
        return repository.save(item);
    }

    @Override public CartItem get(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @Override public void deleteCartItem(UUID cartItemId) {
        repository.deleteById(cartItemId);
    }

    @Override public List<CartItem> findAll() {
        return repository.findAll();
    }

    @Override public List<CartItem> findAllByCart(Cart cart) {
        return repository.findAllByCart(cart);
    }

    @Override public List<CartItem> findAllByBookId(long bookId) {
        return repository.findAllByBookId(bookId);
    }
}
