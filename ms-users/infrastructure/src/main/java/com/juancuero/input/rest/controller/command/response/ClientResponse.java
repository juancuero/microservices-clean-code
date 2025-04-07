package com.juancuero.input.rest.controller.command.response;

import com.juancuero.model.enums.ClientStatus;

import java.time.LocalDateTime;

public record ClientResponse(
        String uuid,
        String name,
        String identification,
        String phone,
        ClientStatus status,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {}
