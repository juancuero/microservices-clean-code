package com.juancuero.port.input;


import com.juancuero.model.Account;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;

public interface FindAllAccountsQueryHandler {
    PageBase<Account> execute(Pagination pagination);
}