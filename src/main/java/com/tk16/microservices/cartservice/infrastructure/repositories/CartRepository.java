package com.tk16.microservices.cartservice.infrastructure.repositories;

import com.tk16.microservices.cartservice.core.models.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CartRepository extends ReactiveCrudRepository<Cart, UUID> {
}
