package com.tk16.microservices.cartservice.core.ports.client;

import com.tk16.microservices.cartservice.core.models.dto.BookDto;
import com.tk16.microservices.cartservice.core.proxy.BookProxy;
import org.springframework.stereotype.Service;

@Service
public class BookClient {

    BookProxy proxy;

    public BookClient(BookProxy proxy) {
        this.proxy = proxy;
    }

    //  get book details from client
    public BookDto getBookById(Long id) {
        // call book proxy
        // check if book is null
        return proxy.getBookById(id);
    }
}
