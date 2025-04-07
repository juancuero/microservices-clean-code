package com.juancuero.query.findByUuid;

import com.juancuero.exception.ResourceNotFoundException;
import com.juancuero.model.Account;
import com.juancuero.port.input.FindAccountByUuidQueryHandler;
import com.juancuero.port.output.AccountQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAccountByUuidQueryHandlerImpl implements FindAccountByUuidQueryHandler {

    private final AccountQueryRepository accountQueryRepository;

    @Override
    public Account execute(UUID uuid) {
        return accountQueryRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Account not found with UUID: " + uuid));
    }
}
