package com.tk16.microservices.cartservice.core.services;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.ports.database.CartDatabase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CartService {

    CartDatabase cartDatabase;
    CartItemService cartItemService;

    public CartService(CartDatabase cartDatabase,
                       CartItemService cartItemService) {
        this.cartDatabase = cartDatabase;
        this.cartItemService = cartItemService;
    }

    // get cart
    public Cart getCartById(UUID id) {
        return cartDatabase.getById(id);
    }

    // get all carts
    public List<Cart> getAllCarts() {
        return cartDatabase.getAllCarts();
    }

    // TODO: delete cart

    // create cart
    public UUID createCart() {
        return cartDatabase.save(new Cart()).getCartId();
    }

    // TODO: remove book from cart


    public List<CartItem> getAllInCart(UUID cart) {
        return cartItemService.getAllCartItemsForCart(cart);
    }

    public BigDecimal getTotalPrice(UUID cartId) throws Exception {
        var cartItems = cartItemService.getAllCartItemsForCart(cartId);
        var totalPrice =
                cartItems.stream().map(CartItem::getItemPrice).reduce(BigDecimal::add);
        return totalPrice.orElseThrow(
                () -> new NoSuchElementException("No Cart Items found")
        );
    }
}
