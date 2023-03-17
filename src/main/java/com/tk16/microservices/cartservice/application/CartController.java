package com.tk16.microservices.cartservice.application;

import com.tk16.microservices.cartservice.core.models.Cart;
import com.tk16.microservices.cartservice.core.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired CartService cartService;

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable UUID id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public UUID createCart() {
        return cartService.createCart();
    }
}
