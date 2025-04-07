package com.juancuero.command.create;

import com.juancuero.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CreateAccountCommandMapper {

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "status", expression = "java(com.juancuero.model.enums.AccountStatus.ACTIVE)"),
            @Mapping(target = "clientUuid", source = "clientUuid")
    })
    Account toAccount(CreateAccountWithNumberCommand command);

    default CreateAccountWithNumberCommand toAccountWithNumber(CreateAccountCommand command, String accountNumber) {
        return new CreateAccountWithNumberCommand(
                accountNumber,
                command.accountType(),
                command.balance(),
                command.status(),
                command.clientUuid()
        );
    }

}
