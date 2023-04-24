package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.application.ports.out.UpdateCartPort;
import com.tk16.microservices.cart_service.domain.Cart;
import com.tk16.microservices.common.PersistenceAdapter;

import java.util.UUID;

@PersistenceAdapter
public class UpdateCartAdapter implements UpdateCartPort {

    private final CartRepository repository;

    public UpdateCartAdapter(CartRepository repository) {
        this.repository = repository;
    }

    @Override public Cart persistCart(Cart cart) {
        var mappedEntity = CartMapper.mapCartToEntity(cart);
        repository.save(mappedEntity);
        return cart;
    }

    @Override public void deleteCart(UUID cartId) {

        // delete all cart items from cart and then cart
        var foundCart = repository.findCartById(cartId);
        repository.delete(foundCart);
    }
}
