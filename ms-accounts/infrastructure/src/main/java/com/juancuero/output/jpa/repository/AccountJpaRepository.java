package com.juancuero.output.jpa.repository;

import com.juancuero.output.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByAccountNumber(String identification);
}
