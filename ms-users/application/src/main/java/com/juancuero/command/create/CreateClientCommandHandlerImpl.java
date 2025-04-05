package com.juancuero.command.create;

import com.juancuero.model.Client;
import com.juancuero.port.input.CreateClientCommandHandler;
import com.juancuero.port.output.ClientCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientCommandHandlerImpl implements CreateClientCommandHandler {

    private final ClientCommandRepository repository;

    @Override
    public Client execute(Client client) {
        Client saved = repository.save(client);
        return saved;
    }
}
