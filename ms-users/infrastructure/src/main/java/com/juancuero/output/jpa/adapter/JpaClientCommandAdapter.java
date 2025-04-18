package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Client;
import com.juancuero.output.jpa.entity.ClientEntity;
import com.juancuero.output.jpa.entity.PersonEntity;
import com.juancuero.output.jpa.entity.enums.ClientStatus;
import com.juancuero.output.jpa.mapper.ClientEntityMapper;
import com.juancuero.output.jpa.repository.ClientJpaRepository;
import com.juancuero.output.jpa.repository.PersonJpaRepository;
import com.juancuero.port.output.ClientCommandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaClientCommandAdapter implements ClientCommandRepository {

    private final ClientJpaRepository repository;
    private final PersonJpaRepository personRepository;
    private final ClientEntityMapper mapper;

    @Override
    @Transactional
    public Client save(Client client) {
        PersonEntity personEntity = mapper.toEntity(client.getPerson());
        personRepository.save(personEntity);
        ClientEntity clientEntity = mapper.toEntity(client);
        clientEntity.setPerson(personEntity);
        ClientEntity savedClient = repository.save(clientEntity);
        return mapper.toDomain(savedClient);
    }

    @Override
    @Transactional
    public Client update(UUID uuid, Client client) {
        ClientEntity existingClient = repository.findById(uuid).get();
        mapper.updateClientEntity(client, existingClient);
        PersonEntity personEntity = personRepository.findById(existingClient.getPerson().getUuid()).get();
        mapper.updatePersonEntity(client.getPerson(), personEntity);
        personRepository.save(personEntity);
        existingClient.setPerson(personEntity);
        ClientEntity updatedClient = repository.save(existingClient);
        return mapper.toDomain(updatedClient);
    }

    @Override
    public void delete(UUID uuid) {
        ClientEntity existingClient = repository.findById(uuid).get();
        existingClient.setStatus(ClientStatus.INACTIVE);
        repository.save(existingClient);
        repository.deleteById(uuid);
        personRepository.deleteById(existingClient.getPerson().getUuid());
    }


}
