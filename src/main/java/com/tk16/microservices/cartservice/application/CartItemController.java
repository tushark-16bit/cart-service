package com.tk16.microservices.cartservice.application;

import com.tk16.microservices.cartservice.core.models.CartItem;
import com.tk16.microservices.cartservice.core.models.request.CreateCartItemRequest;
import com.tk16.microservices.cartservice.core.services.CartItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/cart-item") public class CartItemController {

    CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping public UUID createCartItem(
            @RequestBody CreateCartItemRequest cartItemRequest) {
        return cartItemService.createCartItem(cartItemRequest.bookId,
                cartItemRequest.cartId);
    }

    @GetMapping("/{cartItemId}")
    public CartItem getCartItem(@PathVariable UUID cartItemId) {
        return cartItemService.getCartItem(cartItemId);
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteItem(@PathVariable UUID cartItemId) {
        cartItemService.deleteCartItemById(cartItemId);
    }

    @PatchMapping("/{id}")
    public UUID updateBookInCartItem(@PathVariable UUID id,
                                         @RequestBody CreateCartItemRequest cartItemRequest) {
        return cartItemService.updateCartItem(id, cartItemRequest.bookId,
                cartItemRequest.cartId);
    }
}
