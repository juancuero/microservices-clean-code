package com.juancuero.command.create.movement;

import com.juancuero.model.enums.MovementStatus;
import com.juancuero.model.enums.MovementType;

import java.util.UUID;

public record CreateMovementCommand(
        UUID accountUuid,
        double amount,
        MovementType movementType
) {}
