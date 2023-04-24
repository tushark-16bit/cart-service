package com.tk16.microservices.cart_service.infrastructure.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cart_item")
public class CartItemJpaEntity {

    @Id
    private UUID id;
    private Long bookId;
    private String bookTitle;
    private String bookDescription;
    private BigDecimal bookPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private CartJpaEntity cartEntity;

    public CartItemJpaEntity() {
    }

    public CartItemJpaEntity(UUID id, Long bookId, String bookTitle,
                             String bookDescription, BigDecimal bookPrice,
                             CartJpaEntity cartEntity) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.cartEntity = cartEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public CartJpaEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(
            CartJpaEntity cartEntity) {
        this.cartEntity = cartEntity;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItemJpaEntity that = (CartItemJpaEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (getBookId() != null ? !getBookId().equals(that.getBookId()) :
                that.getBookId() != null) {
            return false;
        }
        if (getBookTitle() != null ?
                !getBookTitle().equals(that.getBookTitle()) :
                that.getBookTitle() != null) {
            return false;
        }
        if (getBookDescription() != null ?
                !getBookDescription().equals(that.getBookDescription()) :
                that.getBookDescription() != null) {
            return false;
        }
        if (getBookPrice() != null ?
                !getBookPrice().equals(that.getBookPrice()) :
                that.getBookPrice() != null) {
            return false;
        }
        return getCartEntity() != null ?
                getCartEntity().equals(that.getCartEntity()) :
                that.getCartEntity() == null;
    }

    @Override public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result +
                (getBookId() != null ? getBookId().hashCode() : 0);
        result = 31 * result +
                (getBookTitle() != null ? getBookTitle().hashCode() : 0);
        result = 31 * result +
                (getBookDescription() != null ?
                        getBookDescription().hashCode() :
                        0);
        result = 31 * result +
                (getBookPrice() != null ? getBookPrice().hashCode() : 0);
        result = 31 * result +
                (getCartEntity() != null ? getCartEntity().hashCode() : 0);
        return result;
    }
}
