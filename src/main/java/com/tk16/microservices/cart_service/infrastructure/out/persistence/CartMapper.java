package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.domain.Cart;

public class CartMapper {

    static Cart mapEntityToCart(CartJpaEntity entity) {
        var cart = new Cart();
        cart.setId(entity.getId());
        cart.setItems(
                entity.getCartItemJpaEntities()
                        .stream()
                        .map(CartItemMapper::mapEntityToCartItem)
                        .toList()
        );
        cart.setTotal(cart.getTotal());
        cart.setUserDetails(
                new Cart.UserDetails(entity.getUserId(), entity.getEmail())
        );
        return cart;
    }

    static CartJpaEntity mapCartToEntity(Cart cart) {
        var entity = new CartJpaEntity();
        entity.setId(cart.getId());
        entity.setUserId(cart.getUserDetails().getUserId());
        entity.setEmail(cart.getUserDetails().getEmail());
        return entity;
    }
}
