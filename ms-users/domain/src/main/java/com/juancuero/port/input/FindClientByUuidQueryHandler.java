package com.juancuero.port.input;

import com.juancuero.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface FindClientByUuidQueryHandler {
    Client execute(UUID uuid);
}