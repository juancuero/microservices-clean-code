package com.juancuero.model;


import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class AccountTransactionsReportResponse {
    private AccountThin account;
    private ClientThin client;
    private List<Movement> movements;
}
