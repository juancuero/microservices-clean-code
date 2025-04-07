package com.juancuero.port.output;

import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface AccountQueryRepository {
    PageBase<Account> findAll(Pagination pagination);
    Optional<Account> findByUuid(UUID uuid);
    boolean existsByAccountNumber(String accountNumber);
}
