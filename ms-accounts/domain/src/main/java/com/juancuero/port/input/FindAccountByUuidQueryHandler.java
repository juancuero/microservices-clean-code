package com.juancuero.port.input;

import com.juancuero.model.Account;

import java.util.UUID;

public interface FindAccountByUuidQueryHandler {
    Account execute(UUID uuid);
}