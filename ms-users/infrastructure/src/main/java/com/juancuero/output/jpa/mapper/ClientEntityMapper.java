package com.juancuero.output.jpa.mapper;

import com.juancuero.model.Client;
import com.juancuero.model.Person;
import com.juancuero.output.jpa.entity.ClientEntity;
import com.juancuero.output.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntity toEntity(Client client);

    Client toDomain(ClientEntity entity);

    PersonEntity toEntity(Person person);

    Person toDomain(PersonEntity entity);
}
