package com.juancuero.input.rest.controller.command.movement.response;

import java.time.LocalDateTime;
import com.juancuero.model.enums.MovementStatus;
import com.juancuero.model.enums.MovementType;

public record MovementResponse(
        String uuid,
        double amount,
        double previousBalance,
        double newBalance,
        MovementType movementType,
        MovementStatus status,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {}
