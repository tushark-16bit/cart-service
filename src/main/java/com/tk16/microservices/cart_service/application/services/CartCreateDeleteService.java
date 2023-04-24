package com.tk16.microservices.cart_service.application.services;

import com.tk16.microservices.cart_service.application.ports.in.CreateCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.DeleteCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.CreateCartCommand;
import com.tk16.microservices.cart_service.application.ports.in.models.DeleteCartCommand;
import com.tk16.microservices.cart_service.application.ports.out.UpdateCartPort;
import com.tk16.microservices.cart_service.domain.Cart;
import com.tk16.microservices.common.UseCase;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@UseCase
@Transactional
public class CartCreateDeleteService
        implements CreateCartUseCase, DeleteCartUseCase {

    private final UpdateCartPort updateCartPort;

    public CartCreateDeleteService(UpdateCartPort updateCartPort) {
        this.updateCartPort = updateCartPort;
    }

    @Override public Cart createCart(CreateCartCommand createCartCommand) {
        var cartCreated =
                CartCommandMapper.createCartFromCommand(createCartCommand);
        return updateCartPort.persistCart(cartCreated);
    }

    @Override public void deleteCart(DeleteCartCommand deleteCartCommand) {
        updateCartPort.deleteCart(deleteCartCommand.getId());
    }

    static class CartCommandMapper {
        static Cart createCartFromCommand(CreateCartCommand createCartCommand) {
            var cart = new Cart();
            cart.setUserDetails(
                    new Cart.UserDetails(createCartCommand.getUserId(),
                            createCartCommand.getEmail()));
            cart.setItems(new ArrayList<>());
            cart.setTotal(BigDecimal.ZERO);
            cart.setId(UUID.randomUUID());
            return cart;
        }
    }
}
