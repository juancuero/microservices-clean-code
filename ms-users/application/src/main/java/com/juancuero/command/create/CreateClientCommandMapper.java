package com.juancuero.command.create;

import com.juancuero.model.Client;
import com.juancuero.model.Person;
import com.juancuero.model.enums.ClientStatus;
import com.juancuero.model.enums.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CreateClientCommandMapper {

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "status", expression = "java(com.juancuero.model.enums.ClientStatus.ACTIVE)"),
            @Mapping(target = "person", expression = "java(toPerson(command))")
    })
    Client toClient(CreateClientCommand command);

    default Person toPerson(CreateClientCommand command) {
        return Person.builder()
                .name(command.name())
                .gender(Gender.valueOf(command.gender()))
                .age(command.age())
                .identification(command.identification())
                .address(command.address())
                .phone(command.phone())
                .build();
    }
}