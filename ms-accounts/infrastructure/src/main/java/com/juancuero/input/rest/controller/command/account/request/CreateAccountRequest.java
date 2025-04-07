package com.juancuero.input.rest.controller.command.account.request;

import com.juancuero.model.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAccountRequest(
        @NotNull AccountType accountType,
        @NotNull Double balance,
        @NotBlank String clientUuid
) {}