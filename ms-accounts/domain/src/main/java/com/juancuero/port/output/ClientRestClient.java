package com.juancuero.port.output;

import com.juancuero.model.ClientThin;

import java.util.UUID;

public interface ClientRestClient {

    ClientThin getClientByUuid(UUID uuid);
}
