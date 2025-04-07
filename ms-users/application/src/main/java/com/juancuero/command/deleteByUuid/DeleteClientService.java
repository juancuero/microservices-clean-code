package com.juancuero.command.deleteByUuid;


import com.juancuero.command.update.UpdateClientService;
import com.juancuero.model.Client;
import com.juancuero.port.input.DeleteClientByUuidCommandHandler;
import com.juancuero.query.findByUuid.FindClientByUuidService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteClientService {
    private final DeleteClientByUuidCommandHandler handler;
    private final FindClientByUuidService  findClientByUuidService;

    public void execute(UUID uuid) {
        findClientByUuidService.execute(uuid);
        handler.execute(uuid);
    }
}
