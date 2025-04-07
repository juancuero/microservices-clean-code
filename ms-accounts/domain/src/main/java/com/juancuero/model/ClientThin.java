package com.juancuero.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientThin(
        UUID uuid,
        String name,
        String identification
) {}
