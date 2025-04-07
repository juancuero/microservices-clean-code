package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.output.jpa.entity.AccountEntity;
import com.juancuero.output.jpa.entity.MovementEntity;
import com.juancuero.output.jpa.mapper.AccountEntityMapper;
import com.juancuero.output.jpa.repository.AccountJpaRepository;
import com.juancuero.port.output.AccountQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaAccountQueryAdapter implements AccountQueryRepository {

    private final AccountJpaRepository repository;
    private final AccountEntityMapper mapper;

    @Override
    public PageBase<Account> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(
                pagination.getPage(),
                pagination.getSize()
        );

        Page<AccountEntity> page = repository.findAll(pageable);
        return new PageBase<>(
                pagination.getPage(),
                pagination.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.isEmpty(),
                page.getContent().stream()
                        .map(mapper::toDomain)
                        .collect(Collectors.toList())
        );

    }

    @Override
    public Optional<Account> findByUuid(UUID uuid) {
        return repository.findById(uuid).map(mapper::toDomain);
    }


    @Override
    public List<Account> findByClientUuid(UUID clientUuid) {
        List<AccountEntity> data = repository.findByClientUuid(clientUuid);
        return data.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return repository.existsByAccountNumber(accountNumber);
    }


}
