package com.juancuero.input.rest.controller.command.movement.response;

import java.time.LocalDateTime;
import com.juancuero.model.enums.AccountType;
import com.juancuero.model.enums.AccountStatus;

public record AccountThin(
        String uuid,
        String accountNumber,
        AccountType accountType,
        double balance
) {}
