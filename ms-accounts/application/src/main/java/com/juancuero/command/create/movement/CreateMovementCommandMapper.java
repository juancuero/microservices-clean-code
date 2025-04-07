package com.juancuero.command.create.movement;


import com.juancuero.model.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CreateMovementCommandMapper {

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "accountUuid", source = "accountUuid")
    })
    Movement toMovement(CreateMovementCommand command);



}
