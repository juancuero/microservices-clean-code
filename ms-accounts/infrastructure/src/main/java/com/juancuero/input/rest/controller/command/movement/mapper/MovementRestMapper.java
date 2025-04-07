package com.juancuero.input.rest.controller.command.movement.mapper;

import com.juancuero.command.create.movement.CreateMovementCommand;
import com.juancuero.input.rest.controller.command.movement.request.CreateMovementRequest;
import com.juancuero.input.rest.controller.command.movement.response.MovementResponse;
import com.juancuero.model.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovementRestMapper {

    @Mapping(target = "accountUuid", source = "accountUuid")
    CreateMovementCommand toCreateMovementCommand(CreateMovementRequest request);

    MovementResponse toResponse(Movement movement);
}
