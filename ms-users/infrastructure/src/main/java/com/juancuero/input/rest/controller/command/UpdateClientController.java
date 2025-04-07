package com.juancuero.input.rest.controller.command;

import com.juancuero.command.update.UpdateClientService;
import com.juancuero.input.rest.controller.command.mapper.ClientRestMapper;
import com.juancuero.input.rest.controller.command.request.UpdateClientRequest;
import com.juancuero.input.rest.controller.command.response.ClientResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class UpdateClientController {

    private final UpdateClientService updateClientService;
    private final ClientRestMapper mapper;

    @PutMapping("/{uuid}")
    public ResponseEntity<ClientResponse> update(@PathVariable UUID uuid, @Valid @RequestBody UpdateClientRequest request) {

        var updateClientCommand = mapper.toUpdateClientCommand(request);
        var updatedClient = updateClientService.execute(uuid,updateClientCommand);
        var response = mapper.toResponse(updatedClient);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
