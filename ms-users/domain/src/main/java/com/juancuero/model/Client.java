package com.juancuero.model;

import com.juancuero.model.abstracts.BaseModel;
import com.juancuero.model.enums.ClientStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Client extends BaseModel {
    private Person person;
    private String password;
    private ClientStatus status;
}
