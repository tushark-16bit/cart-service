package com.tk16.microservices.cartservice.core.models;

import java.math.BigDecimal;

public class BookDto {

  private long bookId;
  private String title;
  private String description;
  private BigDecimal price;

  public BookDto() {}

  public BookDto(Long bookId, String title, String description, BigDecimal price) {
    this.bookId = bookId;
    this.title = title;
    this.description = description;
    this.price = price;
  }

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
