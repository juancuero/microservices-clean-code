package com.juancuero.model;

import com.juancuero.model.abstracts.BaseModel;
import com.juancuero.model.enums.AccountStatus;
import com.juancuero.model.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Account extends BaseModel {
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private AccountStatus status;
    private UUID clientUuid;
}
