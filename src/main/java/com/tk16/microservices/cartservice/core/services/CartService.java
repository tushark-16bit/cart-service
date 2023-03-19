package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.CartDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CartService {

    @Autowired CartDatabase cartDatabase;
    @Autowired CartItemService cartItemService;

    // get cart
    public Cart getCartById(UUID id) {
        return cartDatabase.getCartById(id);
        // throw error if not found
    }

    // TODO: delete cart

    // create cart
    public UUID createCart() {
        return cartDatabase.save(new Cart()).getCartId();
    }

    // TODO: remove book from cart


    // get cart items in cart
    public List<CartItem> getAllInCart(UUID cart) {
        return cartItemService.getAllCartItemsForCart(cart);
    }

    // get total price of cart
    // get all cart items in cart
    // price calculator for items
    public BigDecimal getTotalPrice(UUID cartId) throws Exception {
        var cartItems = cartItemService.getAllCartItemsForCart(cartId);
        var totalPrice =
                cartItems.stream().map(CartItem::getItemPrice).reduce(BigDecimal::add);
        return totalPrice.orElseThrow(
                () -> new NoSuchElementException("No Cart Items found")
        );
    }
}
