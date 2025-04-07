package com.juancuero.command.update;

import com.juancuero.model.Client;
import com.juancuero.model.Person;
import com.juancuero.model.enums.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UpdateClientCommandMapper {

    @Mappings({
            @Mapping(target = "uuid", source =  "uuid"),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "person", expression = "java(toPerson(command))")
    })
    Client toClient(UpdateClientCommand command);

    default Person toPerson(UpdateClientCommand command) {
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
