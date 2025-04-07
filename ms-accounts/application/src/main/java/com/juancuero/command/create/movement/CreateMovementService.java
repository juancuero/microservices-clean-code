package com.juancuero.command.create.movement;

import com.juancuero.model.Movement;
import com.juancuero.port.input.CreateMovementCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateMovementService {

    private final CreateMovementCommandHandler handler;
    private final CreateMovementCommandMapper mapper;

    public Movement execute(CreateMovementCommand command) {
        Movement movement = mapper.toMovement(command);
        System.out.println("La que envia "+movement.getAccountUuid());
        return handler.execute(movement);
    }


}
