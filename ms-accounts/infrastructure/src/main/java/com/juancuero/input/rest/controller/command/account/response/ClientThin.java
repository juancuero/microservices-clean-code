package com.juancuero.input.rest.controller.command.account.response;

import java.util.UUID;

public record ClientThin(
        UUID uuid,
        String name,
        String identification
) {}
