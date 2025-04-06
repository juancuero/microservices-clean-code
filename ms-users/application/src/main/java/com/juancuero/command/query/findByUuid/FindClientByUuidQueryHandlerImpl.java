package com.juancuero.command.query.findByUuid;

import com.juancuero.exception.ResourceNotFoundException;
import com.juancuero.model.Client;
import com.juancuero.port.input.FindClientByUuidQueryHandler;
import com.juancuero.port.output.ClientQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindClientByUuidQueryHandlerImpl implements FindClientByUuidQueryHandler {

    private final ClientQueryRepository clientQueryRepository;

    @Override
    public Client execute(UUID uuid) {
        return clientQueryRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Client not found with UUID: " + uuid));
    }
}
