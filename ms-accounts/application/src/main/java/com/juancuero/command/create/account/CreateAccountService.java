package com.juancuero.command.create.account;

import com.juancuero.model.Account;
import com.juancuero.port.input.CreateAccountCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@AllArgsConstructor
public class CreateAccountService {

    private final CreateAccountCommandHandler handler;
    private final CreateAccountCommandMapper mapper;

    public Account execute(CreateAccountCommand command) {
        String accountNumber = generateAccountNumber();
        Account client = mapper.toAccount(mapper.toAccountWithNumber(command,accountNumber));
        return handler.execute(client);
    }

    private static String generateAccountNumber() {
        int[] offsets = {1, 5, 7, 9};
        SecureRandom random = new SecureRandom();
        int offset = offsets[random.nextInt(offsets.length)];
        long timestamp = System.currentTimeMillis() / 1000;
        int randomPart = random.nextInt(90) + 10;
        String accountNumber = String.valueOf(timestamp) + randomPart;
        accountNumber = accountNumber.substring(0, 12);
        StringBuilder accountNumberFinal = new StringBuilder();
        for (char digit : accountNumber.toCharArray()) {
            int digitValue = Character.getNumericValue(digit);
            int newDigitValue = (digitValue + offset) % 10;
            accountNumberFinal.append(newDigitValue);
        }
        return accountNumberFinal.toString();
    }
}
