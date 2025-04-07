package com.juancuero.query.findByUuid;

import com.juancuero.model.Account;
import com.juancuero.port.input.FindAccountByUuidQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAccountByUuidService {

    private final FindAccountByUuidQueryHandler handler;

    public Account execute(UUID uuid) {
        return handler.execute(uuid);
    }
}
