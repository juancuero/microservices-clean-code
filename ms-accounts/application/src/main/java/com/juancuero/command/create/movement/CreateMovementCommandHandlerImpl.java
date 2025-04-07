package com.juancuero.command.create.movement;

import com.juancuero.model.Movement;
import com.juancuero.port.input.CreateMovementCommandHandler;
import com.juancuero.port.output.MovementCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMovementCommandHandlerImpl implements CreateMovementCommandHandler {

    private final MovementCommandRepository repository;

    @Override
    public Movement execute(Movement movement) {
        System.out.println("account "+movement.getAccountUuid());
        Movement saved = repository.save(movement);
        return saved;
    }
}
