package com.juancuero.port.output;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface ClientQueryRepository {
    PageBase<Client> findAll(Pagination pagination);
    Optional<Client> findByUuid(UUID uuid);
}
