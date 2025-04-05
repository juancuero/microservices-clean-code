package com.juancuero.input.rest.controller.command.response;

import java.time.LocalDateTime;

public record ClientResponse(
        String uuid,
        String name,
        String identification,
        String phone,
        String status,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {}
