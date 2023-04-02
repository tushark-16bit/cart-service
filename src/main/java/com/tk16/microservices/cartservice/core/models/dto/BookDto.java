package com.tk16.microservices.cartservice.core.models.dto;

import java.math.BigDecimal;

public record BookDto(long bookId,
                      String title,
                      String description,
                      BigDecimal price) {}
