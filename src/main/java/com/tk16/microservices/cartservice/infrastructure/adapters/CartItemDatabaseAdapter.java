package com.tk16.microservices.cartservice.infrastructure.adapters;

import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.CartItemDatabase;
import com.tk16.microservices.cartservice.infrastructure.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartItemDatabaseAdapter implements CartItemDatabase {

    @Autowired CartItemRepository repository;

    @Override public CartItem save(CartItem item) {
        return repository.save(item);
    }

    @Override public CartItem get(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
