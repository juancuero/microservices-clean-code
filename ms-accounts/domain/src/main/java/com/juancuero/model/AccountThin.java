package com.juancuero.model;

import com.juancuero.model.enums.AccountType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AccountThin(
        UUID uuid,
        String accountNumber,
        AccountType accountType,
        double balance
) {}