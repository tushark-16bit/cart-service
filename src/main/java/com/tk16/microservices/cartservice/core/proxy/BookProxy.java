package com.tk16.microservices.cartservice.core.proxy;

import com.tk16.microservices.cartservice.core.models.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${book-service-name}")
public interface BookProxy {

    @GetMapping("/user/book/{id}") BookDto getBookById(@PathVariable Long id);
}
