package com.juancuero.model;

import com.juancuero.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreationEvent {
    private UUID clientUuid;
    private AccountType accountType;
}
