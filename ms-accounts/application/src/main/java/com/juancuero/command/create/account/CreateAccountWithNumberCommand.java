package com.juancuero.command.create.account;

import com.juancuero.model.enums.AccountStatus;
import com.juancuero.model.enums.AccountType;

import java.util.UUID;

public record CreateAccountWithNumberCommand(
        String accountNumber,
        AccountType accountType,
        double balance,
        AccountStatus status,
        UUID clientUuid
) {}
