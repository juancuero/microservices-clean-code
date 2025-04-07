package com.juancuero.command.create;

import com.juancuero.model.enums.AccountType;
import com.juancuero.model.enums.AccountStatus;

public record CreateAccountCommand(
        AccountType accountType,
        double balance,
        AccountStatus status,
        String clientUuid
) {}
