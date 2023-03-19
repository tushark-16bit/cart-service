package com.tk16.microservices.cartservice.infrastructure.adapters;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import com.tk16.microservices.cartservice.core.ports.CartItemDatabase;
import com.tk16.microservices.cartservice.infrastructure.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class CartItemDatabaseAdapter implements CartItemDatabase {

    @Autowired CartItemRepository repository;
    @Autowired CartDatabase cartDatabase;

    @Override public CartItem save(CartItem item) {
        return repository.save(item);
    }

    @Override public CartItem get(UUID id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
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
