package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.application.ports.out.LoadCartItemPort;
import com.tk16.microservices.cart_service.application.ports.out.LoadCartPort;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.PersistenceAdapter;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
public class LoadCartItemAdapter implements LoadCartItemPort {

    private final CartItemRepository cartItemRepository;
    private final LoadCartPort loadCartPort;

    public LoadCartItemAdapter(CartItemRepository cartItemRepository,
                               LoadCartPort loadCartPort) {
        this.cartItemRepository = cartItemRepository;
        this.loadCartPort = loadCartPort;
    }

    @Override public CartItem readCartItem(UUID cartItemId) {
        var found =
                cartItemRepository.findCartItemById(cartItemId);
        return CartItemMapper.mapEntityToCartItem(found);
    }

    @Override public List<CartItem> loadCartItemsInCart(UUID cartId) {
        return loadCartPort.readCart(cartId)
                .getItems();
    }
}
