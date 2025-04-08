package com.juancuero.input.rest.controller.query;


import com.juancuero.input.rest.controller.command.account.mapper.AccountRestMapper;
import com.juancuero.input.rest.controller.command.account.response.AccountResponse;
import com.juancuero.model.Account;
import com.juancuero.query.findByUuid.FindAccountByUuidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("cuentas")
@RequiredArgsConstructor
public class FindAccountByUuidController {

    private final FindAccountByUuidService service;
    private final AccountRestMapper accountRestMapper;

    @GetMapping("/{uuid}")
    public ResponseEntity<AccountResponse> findByUuid(@PathVariable UUID uuid) {
            Account account = service.execute(uuid);
            AccountResponse response = accountRestMapper.toResponse(account);
            return ResponseEntity.ok(response);
    }
}
