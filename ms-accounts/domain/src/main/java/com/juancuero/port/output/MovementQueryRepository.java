package com.juancuero.port.output;


import com.juancuero.model.Movement;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MovementQueryRepository {
    List<Movement> findMovementsByAccountUuidAndDateBetween(UUID accountUuid, LocalDate startDate, LocalDate endDate);
}
