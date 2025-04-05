package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Client;
import com.juancuero.output.jpa.entity.ClientEntity;
import com.juancuero.output.jpa.entity.PersonEntity;
import com.juancuero.output.jpa.mapper.ClientEntityMapper;
import com.juancuero.output.jpa.repository.ClientJpaRepository;
import com.juancuero.output.jpa.repository.PersonJpaRepository;
import com.juancuero.port.output.ClientCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaClientCommandAdapter implements ClientCommandRepository {

    private final ClientJpaRepository repository;
    private final PersonJpaRepository personRepository;
    private final ClientEntityMapper mapper;

    @Override
    public Client save(Client client) {
        PersonEntity personEntity = mapper.toEntity(client.getPerson());
        personRepository.save(personEntity);

        ClientEntity clientEntity = mapper.toEntity(client);
        clientEntity.setPerson(personEntity);

        ClientEntity savedClient = repository.save(clientEntity);
        return mapper.toDomain(savedClient);
    }

}
