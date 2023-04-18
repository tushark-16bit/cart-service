package com.tk16.microservices.cart_service.infrastructure.out.web;

import com.tk16.microservices.cart_service.domain.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${book-service-name}")
public interface BookProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/book/read/{bookId}")
    BookDto readBookDetails(@PathVariable Long bookId);

    default CartItem.BookDetails getBookFromServer(Long id) {
        var book = readBookDetails(id);
        return BookDtoToBookDetailsMapper.mapBookToBookDetails(book);
    }

    class BookDtoToBookDetailsMapper {
        static CartItem.BookDetails mapBookToBookDetails(BookDto book) {
            return new CartItem.BookDetails(book.getBookId().bookId,
                    book.getTitle(), book.getDescription(), book.getPrice());
        }
    }
}
