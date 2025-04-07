package com.juancuero.port.output;

import com.juancuero.model.Movement;

public interface MovementCommandRepository {
    Movement save(Movement movement);
}
