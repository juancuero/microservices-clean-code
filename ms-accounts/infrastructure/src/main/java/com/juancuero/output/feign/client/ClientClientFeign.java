package com.juancuero.output.feign.client;

import com.juancuero.model.ClientThin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;

@FeignClient(name = "${ms.users.name}", url = "${ms.users.url}")
public interface ClientClientFeign {

    @GetMapping("/api/clients/{uuid}")
    ResponseEntity<ClientThin> getClientByUuid(@PathVariable("uuid") UUID uuid);
}
