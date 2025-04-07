package com.juancuero.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountReportRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID clientUuid;
}
