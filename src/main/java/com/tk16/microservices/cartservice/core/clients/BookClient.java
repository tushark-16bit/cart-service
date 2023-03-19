package com.tk16.microservices.cartservice.core.clients;

import com.tk16.microservices.cartservice.core.models.BookDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BookClient {

//     get book details from client
    public BookDto getBookById(Long id) {
        // call book proxy
        // check if book is null
        return new BookDto(id, "Harry Potter", "Greatest " +
                "Book series ever", BigDecimal.valueOf(100));
    }
}
