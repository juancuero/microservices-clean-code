package com.juancuero.port.output;

import com.juancuero.model.Client;
public interface ClientCommandRepository {
    Client save(Client client);
}
