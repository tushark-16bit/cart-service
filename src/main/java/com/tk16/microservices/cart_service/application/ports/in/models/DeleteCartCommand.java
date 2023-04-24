package com.tk16.microservices.cart_service.application.ports.in.models;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class DeleteCartCommand {

    @NotNull
    private UUID id;

    public DeleteCartCommand() {
    }

    public DeleteCartCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
