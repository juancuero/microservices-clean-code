package com.juancuero.input.rest.controller.command.response;

import java.time.LocalDateTime;
import com.juancuero.model.enums.AccountType;
import com.juancuero.model.enums.AccountStatus;

public record AccountResponse(
        String uuid,
        String accountNumber,
        AccountType accountType,
        double balance,
        AccountStatus status,
        String clientUuid,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {}
