package com.juancuero.output.jpa.entity;

import com.juancuero.output.jpa.entity.abstracts.BaseModel;
import com.juancuero.output.jpa.entity.enums.ClientStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
@SQLDelete(sql = "UPDATE clients SET is_deleted = true, deleted_at = now() WHERE uuid = ? AND version = ?")
@Where(clause = "is_deleted IS FALSE OR is_deleted IS NULL")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity extends BaseModel {

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClientStatus status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_uuid", referencedColumnName = "uuid", nullable = false, unique = true)
    private PersonEntity person;
}
