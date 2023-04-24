package com.tk16.microservices.cart_service.infrastructure.out.web;

import com.tk16.microservices.cart_service.application.ports.out.LoadBookPort;
import com.tk16.microservices.cart_service.domain.CartItem;
import org.springframework.stereotype.Component;

@Component
public class LoadBookAdapter implements LoadBookPort {

    private final BookProxy bookProxy;

    public LoadBookAdapter(BookProxy bookProxy) {
        this.bookProxy = bookProxy;
    }

    // send query
    // map response from book to book Details
    @Override public CartItem.BookDetails loadBook(Long bookId) {
        return bookProxy.getBookFromServer(bookId);
    }
}
