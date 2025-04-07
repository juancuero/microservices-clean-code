package com.juancuero.query.findAll;

import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.port.input.FindAllAccountsQueryHandler;
import com.juancuero.port.output.AccountQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllAccountsQueryHandlerImpl implements FindAllAccountsQueryHandler {

    private final AccountQueryRepository accountQueryRepository;

    @Override
    public PageBase<Account> execute(Pagination pagination) {
        return accountQueryRepository.findAll(pagination);
    }
}
