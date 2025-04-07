package com.juancuero.input.rest.controller.query;

import com.juancuero.input.rest.controller.command.account.mapper.AccountRestMapper;
import com.juancuero.input.rest.controller.command.account.response.AccountResponse;
import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.output.jpa.adapter.JpaAccountQueryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class FindAllAccountController {

    private final JpaAccountQueryAdapter accountQueryAdapter;
    private final AccountRestMapper mapper;

    @GetMapping
    public ResponseEntity<PageBase<AccountResponse>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        size = Math.max(size, 1);
        page = Math.max(page, 0);

        Pagination pagination = new Pagination(page, size, "", "");

        PageBase<Account> accountPage = accountQueryAdapter.findAll(pagination);

        PageBase<AccountResponse> response = new PageBase<>(
                accountPage.getPage(),
                accountPage.getSize(),
                accountPage.getTotalPages(),
                accountPage.getTotalElements(),
                accountPage.isEmpty(),
                accountPage.getContent().stream()
                        .map(mapper::toResponse)
                        .toList()
        );

        return ResponseEntity.ok(response);
    }

}
