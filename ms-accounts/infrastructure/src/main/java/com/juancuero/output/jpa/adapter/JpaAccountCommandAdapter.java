package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Account;
import com.juancuero.output.jpa.entity.AccountEntity;
import com.juancuero.output.jpa.mapper.AccountEntityMapper;
import com.juancuero.output.jpa.repository.AccountJpaRepository;
import com.juancuero.port.output.AccountCommandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaAccountCommandAdapter implements AccountCommandRepository {

    private final AccountJpaRepository repository;
    private final AccountEntityMapper mapper;

    @Override
    @Transactional
    public Account save(Account account) {
        AccountEntity accountEntity = mapper.toEntity(account);
        AccountEntity savedAccount = repository.save(accountEntity);
        return mapper.toDomain(savedAccount);
    }




}
