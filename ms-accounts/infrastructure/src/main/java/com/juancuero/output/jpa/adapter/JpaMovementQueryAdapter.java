package com.juancuero.output.jpa.adapter;

import com.juancuero.model.Movement;
import com.juancuero.output.jpa.entity.MovementEntity;
import com.juancuero.output.jpa.mapper.MovementEntityMapper;
import com.juancuero.output.jpa.repository.MovementJpaRepository;
import com.juancuero.port.output.MovementQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaMovementQueryAdapter implements MovementQueryRepository {

    private final MovementJpaRepository repository;
    private final MovementEntityMapper mapper;


    @Override
    public List<Movement> findMovementsByAccountUuidAndDateBetween(UUID accountUuid, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        List<MovementEntity> movementEntities = repository.findMovementsByAccountUuidAndCreatedAtBetween(accountUuid, startDateTime, endDateTime);
        return movementEntities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

}
