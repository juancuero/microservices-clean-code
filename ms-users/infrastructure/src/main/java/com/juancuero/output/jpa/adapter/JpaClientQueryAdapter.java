package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.output.jpa.entity.ClientEntity;
import com.juancuero.output.jpa.mapper.ClientEntityMapper;
import com.juancuero.output.jpa.repository.ClientJpaRepository;
import com.juancuero.port.output.ClientQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaClientQueryAdapter implements ClientQueryRepository {

    private final ClientJpaRepository repository;
    private final ClientEntityMapper mapper;

    @Override
    public PageBase<Client> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(
                pagination.getPage(),
                pagination.getSize()
        );
        
        Page<ClientEntity> page = repository.findAll(pageable);
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



}
