package com.tk16.microservices.cartservice.application;

import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.request.CreateCartItemRequest;
import com.tk16.microservices.cartservice.core.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-item")
public class CartItemController {

    @Autowired CartItemService cartItemService;

    @PostMapping
    public CartItem createCartItem(@RequestBody CreateCartItemRequest cartItemRequest) {
        return cartItemService.createCartItem(cartItemRequest.bookId,
                cartItemRequest.cartId);
    }
}
