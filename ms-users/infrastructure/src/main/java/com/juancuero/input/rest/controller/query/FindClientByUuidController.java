package com.juancuero.input.rest.controller.query;


import com.juancuero.query.findByUuid.FindClientByUuidService;
import com.juancuero.input.rest.controller.command.response.ClientResponse;
import com.juancuero.model.Client;
import com.juancuero.input.rest.controller.command.mapper.ClientRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class FindClientByUuidController {

    private final FindClientByUuidService service;
    private final ClientRestMapper clientRestMapper;

    @GetMapping("/{uuid}")
    public ResponseEntity<ClientResponse> findByUuid(@PathVariable UUID uuid) {
            Client client = service.execute(uuid);
            ClientResponse response = clientRestMapper.toResponse(client);
            return ResponseEntity.ok(response);
    }
}
