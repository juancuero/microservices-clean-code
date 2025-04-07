package com.juancuero.input.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juancuero.command.create.CreateAccountCommand;
import com.juancuero.command.create.CreateAccountService;
import com.juancuero.model.AccountCreationEvent;
import com.juancuero.model.enums.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaClientConsumer {

    private final CreateAccountService createAccountService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "account.created", groupId = "accounts-service-group")
    public void consumeAccountCreationEvent(String message) {
        try {
            AccountCreationEvent event = objectMapper.readValue(message, AccountCreationEvent.class);
            CreateAccountCommand createAccountCommand = mapToCreateAccountCommand(event);
            createAccountService.execute(createAccountCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CreateAccountCommand mapToCreateAccountCommand(AccountCreationEvent event) {
        return new CreateAccountCommand(
                event.getAccountType(),
                0.0,
               AccountStatus.ACTIVE,
                event.getClientUuid()
        );
    }
}
