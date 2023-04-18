package com.tk16.microservices.cart_service.application.services;

import com.tk16.microservices.cart_service.application.ports.in.AddBookToCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.AddBookToCartCommand;
import com.tk16.microservices.cart_service.application.ports.out.LoadBookPort;
import com.tk16.microservices.cart_service.application.ports.out.UpdateCartItemPort;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.UseCase;
import jakarta.transaction.Transactional;

@UseCase
@Transactional
public class AddBookToCartService implements AddBookToCartUseCase {

    private final LoadBookPort loadBookPort;
    private final UpdateCartItemPort updateCartItemPort;

    public AddBookToCartService(LoadBookPort loadBookPort,
                                UpdateCartItemPort updateCartItemPort) {
        this.loadBookPort = loadBookPort;
        this.updateCartItemPort = updateCartItemPort;
    }

    @Override public void addBookToCart(AddBookToCartCommand command) {
        var bookDetails = loadBookPort.loadBook(command.getBookId());
        var cartItemCreated = new CartItem(bookDetails);
        updateCartItemPort.persistCartItemToCart(command.getCartId(), cartItemCreated);
    }
}
