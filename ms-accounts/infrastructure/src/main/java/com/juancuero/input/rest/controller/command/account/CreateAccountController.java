package com.juancuero.input.rest.controller.command.account;

import com.juancuero.command.create.account.CreateAccountService;
import com.juancuero.input.rest.controller.command.account.mapper.AccountRestMapper;
import com.juancuero.input.rest.controller.command.account.request.CreateAccountRequest;
import com.juancuero.input.rest.controller.command.account.response.AccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class CreateAccountController {

    private final CreateAccountService createAccountService;
    private final AccountRestMapper mapper;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody CreateAccountRequest request) {
        var createdAccount = createAccountService.execute(mapper.toCreateAccountCommand(request));
        var response = mapper.toResponse(createdAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
