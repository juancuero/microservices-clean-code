package com.juancuero.output.jpa.adapter;

import com.juancuero.exception.InsufficientBalanceException;
import com.juancuero.exception.ResourceNotFoundException;
import com.juancuero.model.Movement;
import com.juancuero.model.enums.MovementType;
import com.juancuero.output.jpa.entity.AccountEntity;
import com.juancuero.output.jpa.entity.MovementEntity;
import com.juancuero.output.jpa.entity.enums.MovementStatus;
import com.juancuero.output.jpa.mapper.MovementEntityMapper;
import com.juancuero.output.jpa.repository.AccountJpaRepository;
import com.juancuero.output.jpa.repository.MovementJpaRepository;
import com.juancuero.port.output.MovementCommandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaMovementCommandAdapter implements MovementCommandRepository {

    private final MovementJpaRepository repository;
    private final AccountJpaRepository accountRepository;
    private final MovementEntityMapper mapper;

    @Override
    @Transactional(dontRollbackOn = InsufficientBalanceException.class)
    public Movement save(Movement movement) {

        AccountEntity accountEntity = accountRepository.findById(movement.getAccountUuid())
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Account not found for UUID: " + movement.getAccountUuid());
                });

        double previousBalance = accountEntity.getBalance();
        if (movement.getMovementType() == MovementType.WITHDRAWAL) {
            if (accountEntity.getBalance() < movement.getAmount()) {
                MovementEntity rejectedMovement = new MovementEntity();
                rejectedMovement.setAmount(movement.getAmount());
                rejectedMovement.setMovementType(mapper.mapMovementType(movement.getMovementType()));
                rejectedMovement.setStatus(MovementStatus.REJECTED);
                rejectedMovement.setAccount(accountEntity);
                rejectedMovement.setPreviousBalance(previousBalance);
                rejectedMovement.setNewBalance(previousBalance);
                repository.save(rejectedMovement);
                throw new InsufficientBalanceException();
            }

            accountEntity.setBalance(accountEntity.getBalance() - movement.getAmount());
        } else if (movement.getMovementType() == MovementType.DEPOSIT) {
            accountEntity.setBalance(accountEntity.getBalance() + movement.getAmount());
        }
        double newBalance = accountEntity.getBalance();
        MovementEntity movementEntity = mapper.toEntity(movement);
        movementEntity.setAccount(accountEntity);
        movementEntity.setPreviousBalance(previousBalance);
        movementEntity.setNewBalance(newBalance);
        movementEntity.setStatus(MovementStatus.COMPLETED);
        return mapper.toDomain(repository.save(movementEntity));
    }


}
