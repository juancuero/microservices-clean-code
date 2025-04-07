package com.juancuero.command.update;

import com.juancuero.exception.ResourceAlreadyExistsException;
import com.juancuero.model.Client;
import com.juancuero.port.input.UpdateClientCommandHandler;
import com.juancuero.query.existsByIdentification.ExistsClientByIdentificationQueryHandlerImpl;
import com.juancuero.query.findByUuid.FindClientByUuidQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateClientService {

    private final UpdateClientCommandHandler handler;
    private final UpdateClientCommandMapper mapper;
    private final FindClientByUuidQueryHandlerImpl findClientByUuidQueryHandlerImpl;
    private final ExistsClientByIdentificationQueryHandlerImpl existsClientByIdentificationQueryHandlerImpl;

    public Client execute(UUID uuid, UpdateClientCommand command) {
        Client existingClient =findClientByUuidQueryHandlerImpl.execute(uuid);
        if (!existingClient.getPerson().getIdentification().equals(command.identification())) {
            if (existsClientByIdentificationQueryHandlerImpl.execute(command.identification())) {
                throw new ResourceAlreadyExistsException("A client with this identification already exists.");
            }
        }
        Client client = mapper.toClient(command);
        return handler.execute(uuid, client);
    }
}
