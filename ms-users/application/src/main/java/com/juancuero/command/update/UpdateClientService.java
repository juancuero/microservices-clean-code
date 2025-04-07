package com.juancuero.command.update;

import com.juancuero.model.Client;
import com.juancuero.port.input.UpdateClientCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateClientService {

    private final UpdateClientCommandHandler handler;
    private final UpdateClientCommandMapper mapper;

    public Client execute(UUID uuid, UpdateClientCommand command) {
        Client client = mapper.toClient(command);
        return handler.execute(uuid,client);
    }
}
