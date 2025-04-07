package com.juancuero.port.input;

import com.juancuero.model.Movement;

public interface CreateMovementCommandHandler {
    Movement execute(Movement movement);
}
