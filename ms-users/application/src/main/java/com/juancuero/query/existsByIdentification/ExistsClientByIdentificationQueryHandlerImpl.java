package com.juancuero.query.existsByIdentification;

import com.juancuero.port.input.ExistsClientByIdentificationQueryHandler;
import com.juancuero.port.output.ClientQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExistsClientByIdentificationQueryHandlerImpl implements ExistsClientByIdentificationQueryHandler {

    private final ClientQueryRepository clientQueryRepository;

    @Override
    public boolean execute(String identification) {
        return clientQueryRepository.exitsByIdentification(identification);
    }
}
