package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.clients.BookClient;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import com.tk16.microservices.cartservice.core.ports.CartItemDatabase;
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

    // TODO: delete cart item

    // get cart item by cart
    public CartItem getCartItem(UUID cartItemId) {
        return cartItemDatabase.get(cartItemId);
    }

    @Transactional(rollbackOn = Exception.class)
    public CartItem createCartItem(Long bookId, UUID cartId) throws Exception {
        var cartItem =
                CartItem.of(
                        bookClient.getBookById(bookId),
                        cartDatabase.getCartById(cartId)
                );
        return cartItemDatabase.save(cartItem);
    }

    // get all cart items by cart id
    @Transactional
    public List<CartItem> getAllCartItemsForCart(UUID cartId) {
        var cart = cartDatabase.getCartById(cartId);
        // verify if exists
        return cartItemDatabase.findAllByCart(cart);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemDatabase.findAll();
    }
}
