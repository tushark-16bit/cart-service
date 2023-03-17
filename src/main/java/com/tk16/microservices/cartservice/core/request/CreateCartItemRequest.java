package com.tk16.microservices.cartservice.core.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CreateCartItemRequest {
    @JsonProperty("book-id")
    public long bookId;
    @JsonProperty("cart-id")
    public UUID cartId;
}
