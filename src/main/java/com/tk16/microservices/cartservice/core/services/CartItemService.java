package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.clients.BookClient;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import com.tk16.microservices.cartservice.core.ports.CartItemDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CartItemService {

    @Autowired CartDatabase cartDatabase;
    @Autowired BookClient bookClient;
    @Autowired CartItemDatabase cartItemDatabase;

    // delete cart item

    // get cart item

    // get cart item with same cart id

    // create cart item from book
    // add cart item to cart
    public CartItem createCartItem(Long bookId, UUID cartId) {
        var bookRetrieved = bookClient.getBookById(bookId);
        if (bookRetrieved== null) throw new NoSuchElementException();
        var cart = cartDatabase.getCartById(cartId);
        if(cart == null) throw new NoSuchElementException();
        var cartItem = new CartItem(bookRetrieved.getBookId(),
                bookRetrieved.getDescription(), cart, bookRetrieved.getPrice());
        return cartItemDatabase.save(cartItem);
    }
}
