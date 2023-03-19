package com.tk16.microservices.cartservice.core.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class CartItem {

    @Id
    private UUID cartItemId;
    private long bookId;
    private String bookDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private BigDecimal itemPrice;

    public CartItem() {
    }

    public static CartItem of(BookDto book, Cart cart) {
        var cartItem = new CartItem();
        cartItem.setBookDescription(book.description());
        cartItem.setBookId(book.bookId());
        cartItem.setItemPrice(book.price());
        cartItem.setCart(cart);
        cartItem.setCartItemId(UUID.randomUUID());
        return cartItem;
    }

    public UUID getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(UUID cartItemId) {
        this.cartItemId = cartItemId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
