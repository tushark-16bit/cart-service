package com.tk16.microservices.cartservice.application;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/cart") public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping public UUID createCart() {
        return cartService.createCart();
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable UUID cartId) {
        return cartService.getCartById(cartId);
    }

    @GetMapping("/{cartId}/price")
    public BigDecimal getTotalPrice(@PathVariable UUID cartId) throws Exception {
        return cartService.getTotalPrice(cartId);
    }

    @GetMapping("/{cartId}/cart-items")
    public List<CartItem> getAllCartItemsInCart(@PathVariable UUID cartId) {
        return cartService.getAllInCart(cartId);
    }
}
