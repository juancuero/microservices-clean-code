package com.juancuero.port.input;

import com.juancuero.model.Client;

import java.util.UUID;

public interface UpdateClientCommandHandler {
    Client execute(UUID uuid, Client client);
}
