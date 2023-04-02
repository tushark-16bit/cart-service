package com.tk16.microservices.cartservice.core.ports.database;

import com.tk16.microservices.cartservice.core.models.Cart;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CartDatabase {

    // get All carts
    List<Cart> getAllCarts();

    /**
     * This method is overriden in implementing class but the behavior
     * exposed outside is defined by getById(cartId)
     * @param cartId
     * @return
     */
    Cart getCartById(UUID cartId);

    Cart save(Cart cart);

    void deleteCartById(UUID cartId);

    /**
     * to enforce a contract that only this exception is thrown in case not found
     * @param cartId
     * @return Cart
     */
    default Cart getById(UUID cartId) {
        var cart = getCartById(cartId);

        if(cart == null) throw new EntityNotFoundException("The cart "+cartId+
                "is not " +
                "present in database");
        return cart;
    }
}
