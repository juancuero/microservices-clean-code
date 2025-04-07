package com.juancuero.query.findByUuid;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.port.input.FindAllClientsQueryHandler;
import com.juancuero.port.input.FindClientByUuidQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindClientByUuidService {

    private final FindClientByUuidQueryHandler handler;

    public Client execute(UUID uuid) {
        return handler.execute(uuid);
    }
}
