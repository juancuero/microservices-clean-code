package com.juancuero.command.update;

import com.juancuero.model.Client;
import com.juancuero.port.input.UpdateClientCommandHandler;
import com.juancuero.port.output.ClientCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateClientCommandHandlerImpl implements UpdateClientCommandHandler {

    private final ClientCommandRepository repository;

    @Override
    public Client execute(UUID uuid, Client client) {
        System.out.println("Lo que llega de estuatus es UpdateClientCommandHandlerImpl: "+client.getStatus());
        Client updatedClient = repository.update(uuid,client);
        return updatedClient;
    }
}
