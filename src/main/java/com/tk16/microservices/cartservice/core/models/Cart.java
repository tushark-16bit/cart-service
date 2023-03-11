package com.tk16.microservices.cartservice.core.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Cart {

    private UUID cartId;
    private List<CartItem> cartItems;
    private Instant lastModifiedTime;
    private static final int CART_ITEM_CAPACITY = 10;
}
