package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository
        extends JpaRepository<CartItemJpaEntity, UUID> {

    default CartItemJpaEntity findCartItemById(UUID id) {
        return findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Car Item not found")
                );
    }
}
