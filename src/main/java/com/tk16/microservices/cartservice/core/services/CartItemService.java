package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.ports.client.BookClient;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.database.CartDatabase;
import com.tk16.microservices.cartservice.core.ports.database.CartItemDatabase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartItemService {

    @Autowired CartDatabase cartDatabase;
    @Autowired BookClient bookClient;
    @Autowired CartItemDatabase cartItemDatabase;

    public void deleteCartItemById(UUID cartItemId) {
        cartItemDatabase.deleteCartItem(cartItemId);
    }

    public CartItem getCartItem(UUID cartItemId) {
        return cartItemDatabase.get(cartItemId);
    }

    @Transactional(rollbackOn = Exception.class)
    public UUID createCartItem(Long bookId, UUID cartId) {
        var cartItem =
                CartItem.of(
                        bookClient.getBookById(bookId),
                        cartDatabase.getById(cartId)
                );
        return cartItemDatabase.save(cartItem).getCartItemId();
    }

    public UUID updateCartItem(UUID cartItemId,
                                   long bookId, UUID cartId) {
        var cartItem =
                CartItem.of(
                        bookClient.getBookById(bookId),
                        cartDatabase.getById(cartId)
                );
        cartItem.setCartItemId(cartItemId);
        return cartItemDatabase.save(cartItem).getCartItemId();
    }

    public List<CartItem> getAllCartItemsForCart(UUID cartId) {
        var cart = cartDatabase.getById(cartId);
        return cartItemDatabase.findAllByCart(cart);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemDatabase.findAll();
    }
}
