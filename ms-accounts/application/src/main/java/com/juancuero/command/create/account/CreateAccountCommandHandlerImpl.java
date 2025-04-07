package com.juancuero.command.create.account;

import com.juancuero.model.Account;
import com.juancuero.port.input.CreateAccountCommandHandler;
import com.juancuero.port.output.AccountCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountCommandHandlerImpl implements CreateAccountCommandHandler {

    private final AccountCommandRepository repository;

    @Override
    public Account execute(Account account) {
        Account saved = repository.save(account);
        return saved;
    }
}
