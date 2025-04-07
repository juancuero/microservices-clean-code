package com.juancuero.input.rest.controller.command.movement;

import com.juancuero.command.create.movement.CreateMovementService;
import com.juancuero.input.rest.controller.command.movement.mapper.MovementRestMapper;
import com.juancuero.input.rest.controller.command.movement.request.CreateMovementRequest;
import com.juancuero.input.rest.controller.command.movement.response.MovementResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimientos")
@AllArgsConstructor
public class CreateMovementController {

    private final CreateMovementService createMovementService;
    private final MovementRestMapper mapper;

    @PostMapping
    public ResponseEntity<MovementResponse> create(@Valid @RequestBody CreateMovementRequest request) {
        var createdMovement = createMovementService.execute(mapper.toCreateMovementCommand(request));
        var response = mapper.toResponse(createdMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
