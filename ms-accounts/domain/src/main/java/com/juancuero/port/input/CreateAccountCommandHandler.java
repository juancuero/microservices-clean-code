package com.juancuero.port.input;

import com.juancuero.model.Account;

public interface CreateAccountCommandHandler {
    Account execute(Account account);
}
