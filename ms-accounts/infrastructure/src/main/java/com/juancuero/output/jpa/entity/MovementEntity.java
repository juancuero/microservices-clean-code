package com.juancuero.output.jpa.entity;

import com.juancuero.output.jpa.entity.abstracts.BaseModel;
import com.juancuero.output.jpa.entity.enums.MovementStatus;
import com.juancuero.output.jpa.entity.enums.MovementType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "movements")
@SQLDelete(sql = "UPDATE movements SET is_deleted = true, deleted_at = now() WHERE uuid = ? AND version = ?")
@Where(clause = "is_deleted IS FALSE OR is_deleted IS NULL")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class MovementEntity extends BaseModel {

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double previousBalance;

    @Column(nullable = false)
    private double newBalance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType movementType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementStatus status;
    @ManyToOne
    @JoinColumn(name = "account_uuid", referencedColumnName = "uuid", nullable = false)
    private AccountEntity account;
}
