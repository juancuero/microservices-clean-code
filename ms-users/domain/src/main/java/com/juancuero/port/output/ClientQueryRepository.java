package com.juancuero.port.output;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;

public interface ClientQueryRepository {
    PageBase<Client> findAll(Pagination pagination);
}
