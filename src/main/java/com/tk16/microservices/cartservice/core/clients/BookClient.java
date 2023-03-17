package com.tk16.microservices.cartservice.core.clients;

import com.tk16.microservices.cartservice.core.models.BookDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// will act as proxy for books service
@Service
public class BookClient {

//     get book details from client
    public BookDto getBookById(Long id) {
        return new BookDto(id, "Harry Potter", "Greatest " +
                "Book series ever", BigDecimal.valueOf(100));
    }
}
