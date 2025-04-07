package com.juancuero.port.output;

import com.juancuero.model.AccountCreationEvent;

public interface ClientProducer {
    void dispatchAccountCreationEvent(AccountCreationEvent event);
}
