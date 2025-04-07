package com.juancuero.command.update;

import com.juancuero.model.enums.ClientStatus;

import java.util.UUID;

public record UpdateClientCommand(
        UUID uuid,
        String name,
        String gender,
        int age,
        String identification,
        String address,
        String phone,
        String password,
        ClientStatus status
) {}
