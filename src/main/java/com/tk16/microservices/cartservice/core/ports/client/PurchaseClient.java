package com.tk16.microservices.cartservice.core.ports.client;

// use this to send cart to purchase service through kafka
public interface PurchaseClient {

    void sendCartDetails();
}
