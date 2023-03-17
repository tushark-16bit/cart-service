package com.tk16.microservices.cartservice.infrastructure.repositories;

import com.tk16.microservices.cartservice.core.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
}
