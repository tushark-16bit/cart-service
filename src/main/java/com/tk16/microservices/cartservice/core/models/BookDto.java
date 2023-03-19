package com.tk16.microservices.cartservice.core.models;

import java.math.BigDecimal;

public record BookDto(long bookId,
                      String title,
                      String description,
                      BigDecimal price) {
}
