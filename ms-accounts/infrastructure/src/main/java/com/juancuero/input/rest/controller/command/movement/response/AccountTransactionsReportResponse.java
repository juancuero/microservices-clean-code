package com.juancuero.input.rest.controller.command.movement.response;

import com.juancuero.input.rest.controller.command.account.response.ClientThin;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class AccountTransactionsReportResponse {
    private AccountThin account;
    private ClientThin client;
    private List<MovementResponse> movements;
}
