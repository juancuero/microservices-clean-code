package com.juancuero.port.input;

import com.juancuero.model.AccountReportRequest;
import com.juancuero.model.AccountTransactionsReportResponse;

import java.util.List;

public interface AccountTransactionsReportQueryHandler {
    List<AccountTransactionsReportResponse> execute(AccountReportRequest request);
}