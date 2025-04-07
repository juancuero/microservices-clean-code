package com.juancuero.output.jpa.mapper;

import com.juancuero.model.Movement;
import com.juancuero.output.jpa.entity.MovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovementEntityMapper {


    MovementEntity toEntity(Movement movement);

    @Mappings({
            @Mapping(target = "accountUuid", source = "account.uuid"),
            @Mapping(target = "status", source = "status")
    })
    Movement toDomain(MovementEntity entity);

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true)
    })
    void updateMovementEntity(Movement movement, @MappingTarget MovementEntity movementEntity);

    default com.juancuero.output.jpa.entity.enums.MovementType mapMovementType(com.juancuero.model.enums.MovementType movementType) {
        switch (movementType) {
            case DEPOSIT:
                return com.juancuero.output.jpa.entity.enums.MovementType.DEPOSIT;
            case WITHDRAWAL:
                return com.juancuero.output.jpa.entity.enums.MovementType.WITHDRAWAL;
            default:
                throw new IllegalArgumentException("Unexpected value: " + movementType);
        }
    }
}
