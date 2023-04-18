package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class CartJpaEntity {

    @Id
    private UUID id;
    private UUID userId;
    private String email;
    @OneToMany(mappedBy = "cartEntity", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<CartItemJpaEntity> cartItemJpaEntities;

    public CartJpaEntity() {
    }

    public CartJpaEntity(UUID id, UUID userId, String email) {
        this.id = id;
        this.userId = userId;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CartItemJpaEntity> getCartItemJpaEntities() {
        return cartItemJpaEntities;
    }

    public void setCartItemJpaEntities(
            List<CartItemJpaEntity> cartItemJpaEntities) {
        this.cartItemJpaEntities = cartItemJpaEntities;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartJpaEntity that = (CartJpaEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getUserId().equals(that.getUserId())) return false;
        return getEmail().equals(that.getEmail());
    }

    @Override public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}
