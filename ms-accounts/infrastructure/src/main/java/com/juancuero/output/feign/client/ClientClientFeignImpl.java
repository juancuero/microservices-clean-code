package com.juancuero.output.feign.client;

import com.juancuero.exception.ResourceNotFoundException;
import com.juancuero.model.ClientThin;
import com.juancuero.port.output.ClientRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientClientFeignImpl implements ClientRestClient {

    private final ClientClientFeign clientClientFeign;

    @Override
    public ClientThin getClientByUuid(UUID uuid) {
        try {
            ResponseEntity<ClientThin> response = clientClientFeign.getClientByUuid(uuid);
            return response.getBody();
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        } catch (FeignException e) {
            throw new ResponseStatusException(
                    HttpStatus.valueOf(e.status()),
                    "Error al consultar el cliente: " + e.contentUTF8(),
                    e
            );
        }
    }
}