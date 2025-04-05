package com.juancuero.command.create;

import com.juancuero.model.Client;
import com.juancuero.port.input.CreateClientCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientService {

    private final CreateClientCommandHandler handler;
    private final CreateClientCommandMapper mapper;

    public Client execute(CreateClientCommand command) {
        Client client = mapper.toClient(command);
        return handler.execute(client);
    }
}
