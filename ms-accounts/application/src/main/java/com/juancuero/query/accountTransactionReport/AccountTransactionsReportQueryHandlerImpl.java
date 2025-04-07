package com.juancuero.query.accountTransactionReport;

import com.juancuero.model.Account;
import com.juancuero.model.AccountReportRequest;
import com.juancuero.model.AccountThin;
import com.juancuero.model.AccountTransactionsReportResponse;
import com.juancuero.model.ClientThin;
import com.juancuero.model.Movement;
import com.juancuero.port.input.AccountTransactionsReportQueryHandler;
import com.juancuero.port.output.AccountQueryRepository;
import com.juancuero.port.output.MovementQueryRepository;
import com.juancuero.port.output.ClientRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class AccountTransactionsReportQueryHandlerImpl implements AccountTransactionsReportQueryHandler {

    private final MovementQueryRepository movementQueryRepository;
    private final AccountQueryRepository accountQueryRepository;
    private final ClientRestClient clientRestClient;

    @Override
    public List<AccountTransactionsReportResponse> execute(AccountReportRequest request) {

        ClientThin clientThin = clientRestClient.getClientByUuid(request.getClientUuid());  // Aquí obtenemos el cliente real desde el microservicio ms-users

        List<Account> accounts = accountQueryRepository.findByClientUuid(request.getClientUuid());

        List<AccountTransactionsReportResponse> responseList = accounts.stream()
                .map(account -> {
                    List<Movement> movements = movementQueryRepository.findMovementsByAccountUuidAndDateBetween(
                            account.getUuid(),
                            request.getStartDate(),
                            request.getEndDate()
                    );

                    AccountThin accountThin = AccountThin.builder()
                            .uuid(account.getUuid())
                            .accountNumber(account.getAccountNumber())
                            .accountType(account.getAccountType())
                            .balance(account.getBalance())
                            .build();

                    return AccountTransactionsReportResponse.builder()
                            .account(accountThin)
                            .client(clientThin)
                            .movements(movements)
                            .build();

                })
                .collect(Collectors.toList());

        return responseList;
    }

}
