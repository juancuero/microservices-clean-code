package com.juancuero.output.jpa.repository;

import com.juancuero.output.jpa.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MovementJpaRepository extends JpaRepository<MovementEntity, UUID> {
    List<MovementEntity> findMovementsByAccountUuidAndCreatedAtBetween(
            UUID accountUuid,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    );
}
