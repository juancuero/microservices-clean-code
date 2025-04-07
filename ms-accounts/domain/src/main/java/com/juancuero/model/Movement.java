package com.juancuero.model;

import com.juancuero.model.abstracts.BaseModel;
import com.juancuero.model.enums.MovementStatus;
import com.juancuero.model.enums.MovementType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Movement extends BaseModel {

    private UUID accountUuid;
    private double amount;
    private double previousBalance;
    private double newBalance;
    private MovementType movementType;
    private MovementStatus status;
}
