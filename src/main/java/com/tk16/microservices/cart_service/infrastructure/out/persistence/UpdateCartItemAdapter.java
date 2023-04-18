package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.application.ports.out.LoadCartPort;
import com.tk16.microservices.cart_service.application.ports.out.UpdateCartItemPort;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.PersistenceAdapter;

import java.util.UUID;

@PersistenceAdapter
public class UpdateCartItemAdapter implements UpdateCartItemPort {

    private final LoadCartPort loadCartPort;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public UpdateCartItemAdapter(LoadCartPort loadCartPort,
                                 CartItemRepository cartItemRepository,
                                 CartRepository cartRepository) {
        this.loadCartPort = loadCartPort;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override public CartItem persistCartItemToCart(UUID cartId,
                                                    CartItem cartItem) {

        var mappedEntity = CartItemMapper.mapCartItemToEntity(
                cartItem,
                cartRepository.findCartById(cartId)
        );
        cartItemRepository.save(mappedEntity);
        return cartItem;
    }

    @Override public void deleteCartItem(UUID cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
