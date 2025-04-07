package com.juancuero.input.rest.controller.command;

import com.juancuero.command.deleteByUuid.DeleteClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class DeleteClientController {

    private final DeleteClientService deleteClientService;

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        deleteClientService.execute(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
