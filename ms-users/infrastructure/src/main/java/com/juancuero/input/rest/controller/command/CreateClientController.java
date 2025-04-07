package com.juancuero.input.rest.controller.command;

import com.juancuero.command.create.CreateClientService;
import com.juancuero.input.rest.controller.command.mapper.ClientRestMapper;
import com.juancuero.input.rest.controller.command.request.CreateClientRequest;
import com.juancuero.input.rest.controller.command.response.ClientResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class CreateClientController {

    private final CreateClientService createClientService;
    private final ClientRestMapper mapper;

    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody CreateClientRequest request) {
        var createdClient = createClientService.execute(mapper.toCreateClientCommand(request));
        var response = mapper.toResponse(createdClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
