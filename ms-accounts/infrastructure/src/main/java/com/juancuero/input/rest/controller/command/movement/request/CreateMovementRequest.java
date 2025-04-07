package com.juancuero.input.rest.controller.command.movement.request;

import jakarta.validation.constraints.NotNull;
import com.juancuero.model.enums.MovementType;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CreateMovementRequest(
        @NotNull UUID accountUuid,
        @NotNull @Positive double amount,
        @NotNull MovementType movementType
) {}
