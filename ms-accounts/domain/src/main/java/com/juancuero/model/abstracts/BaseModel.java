package com.juancuero.model.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {

    protected UUID uuid;
    protected Long version;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastModifiedAt;
    protected LocalDateTime deletedAt;
    protected Boolean isDeleted;
}
