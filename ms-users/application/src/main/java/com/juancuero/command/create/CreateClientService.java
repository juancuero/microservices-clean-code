package com.juancuero.command.create;

import com.juancuero.exception.ResourceAlreadyExistsException;
import com.juancuero.model.AccountCreationEvent;
import com.juancuero.model.Client;
import com.juancuero.model.enums.AccountType;
import com.juancuero.port.input.CreateClientCommandHandler;
import com.juancuero.port.output.ClientProducer;
import com.juancuero.query.existsByIdentification.ExistsClientByIdentificationQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientService {

    private final CreateClientCommandHandler handler;
    private final ExistsClientByIdentificationQueryHandlerImpl existsClientByIdentificationQueryHandlerImpl;

    private final ClientProducer clientProducer;

    private final CreateClientCommandMapper mapper;

    public Client execute(CreateClientCommand command) {
        if (existsClientByIdentificationQueryHandlerImpl.execute(command.identification())) {
            throw new ResourceAlreadyExistsException("A client with this identification already exists.");
        }
        Client client = mapper.toClient(command);

        Client createdClient = handler.execute(client);

        AccountCreationEvent accountCreationEvent = new AccountCreationEvent(
                createdClient.getUuid(),
               AccountType.SAVINGS
        );

        clientProducer.dispatchAccountCreationEvent(accountCreationEvent);

        return createdClient;
    }
}
