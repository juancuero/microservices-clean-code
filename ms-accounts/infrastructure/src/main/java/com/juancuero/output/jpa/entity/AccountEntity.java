package com.juancuero.output.jpa.entity;

import com.juancuero.output.jpa.entity.abstracts.BaseModel;
import com.juancuero.output.jpa.entity.enums.AccountStatus;
import com.juancuero.output.jpa.entity.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE accounts SET is_deleted = true, deleted_at = now() WHERE uuid = ? AND version = ?")
@Where(clause = "is_deleted IS FALSE OR is_deleted IS NULL")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity extends BaseModel {

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

    @Column(nullable = false)
    private UUID clientUuid;

}
