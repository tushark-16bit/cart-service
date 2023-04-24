package com.tk16.microservices.cart_service.application.services;

import com.tk16.microservices.cart_service.application.ports.in.ReadCartItemsInCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.ReadCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.ReadCartQuery;
import com.tk16.microservices.cart_service.application.ports.out.LoadCartItemPort;
import com.tk16.microservices.cart_service.application.ports.out.LoadCartPort;
import com.tk16.microservices.cart_service.domain.Cart;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.UseCase;
import jakarta.transaction.Transactional;

import java.util.List;

@UseCase
@Transactional
public class ReadCartService implements ReadCartUseCase,
        ReadCartItemsInCartUseCase {

    private final LoadCartPort loadCartPort;
    private final LoadCartItemPort loadCartItemPort;

    public ReadCartService(LoadCartPort loadCartPort, LoadCartItemPort loadCartItemPort) {
        this.loadCartPort = loadCartPort;
        this.loadCartItemPort = loadCartItemPort;
    }

    @Override
    public List<CartItem> readAllCartItemsInCart(ReadCartQuery query) {
        return loadCartItemPort.loadCartItemsInCart(query.getId());
    }

    @Override public Cart readCart(ReadCartQuery query) {
        return loadCartPort.readCart(query.getId());
    }

    @Override public List<Cart> readAllCarts() {
        return loadCartPort.readAllCarts();
    }
}
