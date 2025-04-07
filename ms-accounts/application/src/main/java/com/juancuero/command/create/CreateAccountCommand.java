package com.juancuero.command.create;

import com.juancuero.model.enums.AccountType;
import com.juancuero.model.enums.AccountStatus;

import java.util.UUID;

public record CreateAccountCommand(
        AccountType accountType,
        double balance,
        AccountStatus status,
        UUID clientUuid
) {}
