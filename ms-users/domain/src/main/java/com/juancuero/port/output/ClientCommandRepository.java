package com.juancuero.port.output;

import com.juancuero.model.Client;

import java.util.UUID;

public interface ClientCommandRepository {
    Client save(Client client);
    Client update(UUID uuid, Client client);
     void delete(UUID uuid);
}
