package com.juancuero.output.jpa.mapper;

import com.juancuero.model.Account;
import com.juancuero.output.jpa.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {

    AccountEntity toEntity(Account account);

    Account toDomain(AccountEntity entity);

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true)
    })
    void updateAccountEntity(Account account, @MappingTarget AccountEntity accountEntity);

}
