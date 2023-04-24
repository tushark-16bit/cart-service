package com.tk16.microservices.cart_service.application.ports.out;

import com.tk16.microservices.cart_service.domain.CartItem;

public interface LoadBookPort {

    CartItem.BookDetails loadBook(Long bookId);
}
