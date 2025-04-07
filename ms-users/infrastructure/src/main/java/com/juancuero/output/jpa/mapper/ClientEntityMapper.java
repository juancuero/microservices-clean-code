package com.juancuero.output.jpa.mapper;

import com.juancuero.model.Client;
import com.juancuero.model.Person;
import com.juancuero.output.jpa.entity.ClientEntity;
import com.juancuero.output.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntity toEntity(Client client);

    Client toDomain(ClientEntity entity);

    PersonEntity toEntity(Person person);

    Person toDomain(PersonEntity entity);


    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true)
    })
    void updateClientEntity(Client client, @MappingTarget ClientEntity clientEntity);

    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "lastModifiedAt", ignore = true),
            @Mapping(target = "deletedAt", ignore = true)
    })
    void updatePersonEntity(Person client, @MappingTarget PersonEntity personEntity);
}
