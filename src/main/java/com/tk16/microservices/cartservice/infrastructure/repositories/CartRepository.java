package com.tk16.microservices.cartservice.infrastructure.repositories;

import com.tk16.microservices.cartservice.core.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
}
