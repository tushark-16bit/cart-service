package com.tk16.microservices.cart_service.infrastructure.in.web.controller;

import com.tk16.microservices.cart_service.application.ports.in.AddBookToCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.CreateCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.DeleteCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.PurchaseCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.ReadCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.RemoveBookFromCartUseCase;
import com.tk16.microservices.cart_service.application.ports.in.models.AddBookToCartCommand;
import com.tk16.microservices.cart_service.application.ports.in.models.CreateCartCommand;
import com.tk16.microservices.cart_service.application.ports.in.models.DeleteCartCommand;
import com.tk16.microservices.cart_service.application.ports.in.models.PurchaseCartCommand;
import com.tk16.microservices.cart_service.application.ports.in.models.ReadCartQuery;
import com.tk16.microservices.cart_service.application.ports.in.models.RemoveBookFromCartCommand;
import com.tk16.microservices.cart_service.domain.Cart;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@PreAuthorize("hasAuthority('OIDC_USER')")
@Retry(name = "read-cart")
@RateLimiter(name = "default")
@Bulkhead(name = "default")
public class CartController {

    private final ReadCartUseCase readCartUseCase;
    private final CreateCartUseCase createCartUseCase;
    private final DeleteCartUseCase deleteCartUseCase;
    private final AddBookToCartUseCase addBookToCartUseCase;
    private final RemoveBookFromCartUseCase removeBookFromCartUseCase;
    private final PurchaseCartUseCase purchaseCartUseCase;

    public CartController(ReadCartUseCase readCartUseCase,
                          CreateCartUseCase createCartUseCase,
                          DeleteCartUseCase deleteCartUseCase,
                          AddBookToCartUseCase addBookToCartUseCase,
                          RemoveBookFromCartUseCase removeBookFromCartUseCase,
                          PurchaseCartUseCase purchaseCartUseCase) {
        this.readCartUseCase = readCartUseCase;
        this.createCartUseCase = createCartUseCase;
        this.deleteCartUseCase = deleteCartUseCase;
        this.addBookToCartUseCase = addBookToCartUseCase;
        this.removeBookFromCartUseCase = removeBookFromCartUseCase;
        this.purchaseCartUseCase = purchaseCartUseCase;
    }

    @GetMapping ResponseEntity<Cart> readCart(@Valid @RequestBody ReadCartQuery query) {
        var cart = readCartUseCase.readCart(query);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/all") ResponseEntity<List<Cart>> readAllCarts() {
        return new ResponseEntity<>(
                readCartUseCase.readAllCarts(),
                HttpStatus.OK
        );
    }

    @PostMapping Cart createCart(@Valid @RequestBody CreateCartCommand createCartCommand) {
        return createCartUseCase.createCart(createCartCommand);
    }

    @DeleteMapping void createCart(@Valid @RequestBody DeleteCartCommand command) {
        deleteCartUseCase.deleteCart(command);
    }

    @PostMapping("/book") void addBookToCart(@Valid @RequestBody AddBookToCartCommand command) {
        addBookToCartUseCase.addBookToCart(command);
    }

    @PatchMapping("/book") void removeBookFromCart(@Valid @RequestBody RemoveBookFromCartCommand command) {
        removeBookFromCartUseCase.removeBookFromCart(command);
    }

    @PostMapping("/purchase") void purchaseCart(@RequestBody PurchaseCartCommand command) {
        purchaseCartUseCase.purchaseCart(command);
    }
}
