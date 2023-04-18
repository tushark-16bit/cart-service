package com.tk16.microservices.cart_service.application.services;

import com.tk16.microservices.cart_service.application.ports.in.RemoveBookFromCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.RemoveBookFromCartCommand;
import com.tk16.microservices.cart_service.application.ports.out.LoadCartItemPort;
import com.tk16.microservices.cart_service.application.ports.out.UpdateCartItemPort;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.UseCase;
import jakarta.transaction.Transactional;

import java.util.Objects;

@UseCase
@Transactional
public class RemoveBookFromCartService implements RemoveBookFromCartUseCase {

    private final LoadCartItemPort loadCartItemPort;
    private final UpdateCartItemPort updateCartItemPort;

    public RemoveBookFromCartService(LoadCartItemPort loadCartItemPort,
                                     UpdateCartItemPort updateCartItemPort) {
        this.loadCartItemPort = loadCartItemPort;
        this.updateCartItemPort = updateCartItemPort;
    }

    @Override
    public void removeBookFromCart(RemoveBookFromCartCommand command) {
        loadCartItemPort.loadCartItemsInCart(command.getCartId())
                .stream()
                .filter(item ->
                        Objects.equals(item.getBookDetails().getId(),
                                command.getBookId()))
                .map(CartItem::getId)
                .forEach(updateCartItemPort::deleteCartItem);
    }
}
