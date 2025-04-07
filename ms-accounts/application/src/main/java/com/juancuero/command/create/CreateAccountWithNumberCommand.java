package com.juancuero.command.create;

import com.juancuero.model.enums.AccountStatus;
import com.juancuero.model.enums.AccountType;

public record CreateAccountWithNumberCommand(
        String accountNumber,
        AccountType accountType,
        double balance,
        AccountStatus status,
        String clientUuid
) {}
