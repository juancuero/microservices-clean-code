package com.juancuero.input.rest.controller.command.request;


import com.juancuero.model.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAccountRequest(
        @NotBlank String accountNumber,
        @NotNull AccountType accountType,
        @NotNull Double balance,
        @NotBlank String clientUuid
) {}
