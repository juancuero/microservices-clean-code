package com.juancuero.input.rest.controller.command.request;

import com.juancuero.model.enums.ClientStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateClientRequest(
        @NotBlank String name,
        @NotBlank String gender,
        @NotNull Integer age,
        @NotBlank String identification,
        @NotBlank String address,
        @NotBlank String phone,
        @NotBlank String password,
        @NotNull ClientStatus status
) {}
