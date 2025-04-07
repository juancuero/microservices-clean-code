package com.juancuero.port.input;

import java.util.UUID;

public interface DeleteClientByUuidCommandHandler {
     void execute(UUID uuid);
}