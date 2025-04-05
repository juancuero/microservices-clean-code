package com.juancuero.command.query.findAll;

import com.juancuero.model.Client;
import com.juancuero.model.pagination.PageBase;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.port.input.FindAllClientsQueryHandler;
import com.juancuero.port.output.ClientQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllClientsQueryHandlerImpl implements FindAllClientsQueryHandler {

    private final ClientQueryRepository clientQueryRepository;

    @Override
    public PageBase<Client> execute(Pagination pagination) {
        return clientQueryRepository.findAll(pagination);
    }
}
