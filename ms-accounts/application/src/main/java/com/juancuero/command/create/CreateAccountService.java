package com.juancuero.command.create;

import com.juancuero.model.Account;
import com.juancuero.port.input.CreateAccountCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAccountService {

    private final CreateAccountCommandHandler handler;
    private final CreateAccountCommandMapper mapper;

    public Account execute(CreateAccountCommand command) {
        Account client = mapper.toAccount(command);
        return handler.execute(client);
    }
}
