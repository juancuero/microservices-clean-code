package com.juancuero.query.findAll;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.port.input.FindAllClientsQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllClientsService {

    private final FindAllClientsQueryHandler handler;

    public PageBase<Client> execute(Pagination query) {
        return handler.execute(query);
    }
}
