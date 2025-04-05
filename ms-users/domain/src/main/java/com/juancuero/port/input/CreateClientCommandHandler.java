package com.juancuero.port.input;

import com.juancuero.model.Client;

public interface CreateClientCommandHandler {
    Client execute(Client client);
}
