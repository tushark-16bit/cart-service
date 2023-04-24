package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<CartJpaEntity, UUID> {

    default CartJpaEntity findCartById(UUID id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Cart Not Found"));
    }
}
