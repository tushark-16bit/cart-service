package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.application.ports.out.LoadCartPort;
import com.tk16.microservices.cart_service.domain.Cart;
import com.tk16.microservices.common.PersistenceAdapter;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
public class LoadCartAdapter implements LoadCartPort {

    private final CartRepository cartRepository;

    public LoadCartAdapter(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override public Cart readCart(UUID id) {
        var found = cartRepository.findCartById(id);
        return CartMapper.mapEntityToCart(found);
    }

    @Override public List<Cart> readAllCarts() {
        return cartRepository.findAll()
                .stream()
                .map(CartMapper::mapEntityToCart)
                .toList();
    }
}
