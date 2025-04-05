package com.juancuero.output.jpa.entity;

import com.juancuero.output.jpa.entity.abstracts.BaseModel;
import com.juancuero.output.jpa.entity.enums.Gender;
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

@Entity
@Table(name = "persons")
@SQLDelete(sql = "UPDATE persons SET is_deleted = true, deleted_at = now() WHERE uuid = ? AND version = ?")
@Where(clause = "is_deleted IS FALSE OR is_deleted IS NULL")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String identification;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;
}
