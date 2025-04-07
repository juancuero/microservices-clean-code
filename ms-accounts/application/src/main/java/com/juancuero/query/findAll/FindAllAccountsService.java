package com.juancuero.query.findAll;

import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.port.input.FindAllAccountsQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllAccountsService {

    private final FindAllAccountsQueryHandler handler;

    public PageBase<Account> execute(Pagination query) {
        return handler.execute(query);
    }
}
