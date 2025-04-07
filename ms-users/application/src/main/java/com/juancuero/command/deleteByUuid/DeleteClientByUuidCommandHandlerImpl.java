package com.juancuero.command.deleteByUuid;

import com.juancuero.model.Client;
import com.juancuero.port.input.DeleteClientByUuidCommandHandler;
import com.juancuero.port.output.ClientCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteClientByUuidCommandHandlerImpl implements DeleteClientByUuidCommandHandler {

    private final ClientCommandRepository repository;

    @Override
    public void execute(UUID uuid) {
       repository.delete(uuid);
    }
}
