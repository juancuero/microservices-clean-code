package com.juancuero.input.rest.controller.command.mapper;

import com.juancuero.command.create.CreateClientCommand;
import com.juancuero.command.update.UpdateClientCommand;
import com.juancuero.input.rest.controller.command.request.CreateClientRequest;
import com.juancuero.input.rest.controller.command.request.UpdateClientRequest;
import com.juancuero.input.rest.controller.command.response.ClientResponse;
import com.juancuero.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientRestMapper {

    CreateClientCommand toCreateClientCommand(CreateClientRequest request);
    UpdateClientCommand toUpdateClientCommand(UpdateClientRequest request);

    @Mappings({
            @Mapping(target = "uuid", source = "uuid"),
            @Mapping(target = "name", source = "person.name"),
            @Mapping(target = "identification", source = "person.identification"),
            @Mapping(target = "phone", source = "person.phone"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "lastModifiedAt", source = "lastModifiedAt")
    })
    ClientResponse toResponse(Client client);
}
