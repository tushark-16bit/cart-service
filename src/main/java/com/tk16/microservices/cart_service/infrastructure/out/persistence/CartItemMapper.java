package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import com.tk16.microservices.cart_service.domain.CartItem;

public class CartItemMapper {

    public static CartItemJpaEntity mapCartItemToEntity(
            CartItem cartItem, CartJpaEntity cart) {
        return new CartItemJpaEntity(
                cartItem.getId(),
                cartItem.getBookDetails().getId(),
                cartItem.getBookDetails().getTitle(),
                cartItem.getBookDetails().getDescription(),
                cartItem.getBookDetails().getPrice(),
                cart);
    }

    public static CartItem mapEntityToCartItem(CartItemJpaEntity cartItemJpa) {
        if (cartItemJpa == null) return null;
        var entity = new CartItem();
        entity.setId(cartItemJpa.getId());
        entity.setBookDetails(
                new CartItem.BookDetails(cartItemJpa.getBookId(),
                        cartItemJpa.getBookTitle(),
                        cartItemJpa.getBookDescription(),
                        cartItemJpa.getBookPrice()));
        return entity;
    }
}
