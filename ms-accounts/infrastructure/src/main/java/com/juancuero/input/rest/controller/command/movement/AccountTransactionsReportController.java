package com.juancuero.input.rest.controller.command.movement;

import com.juancuero.model.AccountReportRequest;
import com.juancuero.model.AccountTransactionsReportResponse;
import com.juancuero.port.input.AccountTransactionsReportQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class AccountTransactionsReportController {

    private final AccountTransactionsReportQueryHandler accountTransactionsReportQueryHandler;

    @GetMapping("/reportes")
    public ResponseEntity<List<AccountTransactionsReportResponse>> getAccountTransactionsReport(
            @RequestParam UUID  clientUuid,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        AccountReportRequest request = AccountReportRequest.builder()
                .clientUuid(clientUuid)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        List<AccountTransactionsReportResponse> response = accountTransactionsReportQueryHandler.execute(request);
        return ResponseEntity.ok(response);
    }
}
