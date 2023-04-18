package com.tk16.microservices.cart_service.application.services;

import com.tk16.microservices.cart_service.application.ports.in.PurchaseCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.PurchaseCartCommand;
import com.tk16.microservices.cart_service.application.ports.out.LoadCartPort;
import com.tk16.microservices.cart_service.application.ports.out.SendPurchaseOrderPort;
import com.tk16.microservices.cart_service.application.ports.out.UpdateCartPort;
import com.tk16.microservices.common.UseCase;
import jakarta.transaction.Transactional;

@UseCase
@Transactional
public class PurchaseCartService implements PurchaseCartUseCase {

    private final SendPurchaseOrderPort sendPurchaseOrderPort;
    private final LoadCartPort loadCartPort;
    private final UpdateCartPort updateCartPort;

    public PurchaseCartService(SendPurchaseOrderPort sendPurchaseOrderPort,
                               LoadCartPort loadCartPort,
                               UpdateCartPort updateCartPort) {
        this.sendPurchaseOrderPort = sendPurchaseOrderPort;
        this.loadCartPort = loadCartPort;
        this.updateCartPort = updateCartPort;
    }

    @Override public void purchaseCart(PurchaseCartCommand command) {
        var cartId = command.getCartId();
        var cart = loadCartPort.readCart(cartId);
        if (cart.getItems().size() == 0) throw new RuntimeException("Cart is empty");
        var messageSent = sendPurchaseOrderPort.sendPurchaseOrder(
                cart
        );
        if (messageSent) updateCartPort.deleteCart(cartId);
    }
}
