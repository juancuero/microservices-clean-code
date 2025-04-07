package com.juancuero.port.output;

import com.juancuero.model.Account;

public interface AccountCommandRepository {
    Account save(Account account);
}
