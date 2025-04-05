package com.juancuero.port.input;


import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;

public interface FindAllClientsQueryHandler {
    PageBase<Client> execute(Pagination pagination);
}