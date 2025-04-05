package com.juancuero.command.create;

public record CreateClientCommand(
        String name,
        String gender,
        int age,
        String identification,
        String address,
        String phone,
        String password
) {}
