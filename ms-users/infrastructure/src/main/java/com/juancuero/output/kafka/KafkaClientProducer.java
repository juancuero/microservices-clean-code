package com.juancuero.output.kafka;

import com.juancuero.model.AccountCreationEvent;
import com.juancuero.port.output.ClientProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaClientProducer implements ClientProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final String TOPIC = "account";

    @Override
    public void dispatchAccountCreationEvent(AccountCreationEvent data) {
        try {
            String eventAsString = objectMapper.writeValueAsString(data);
            kafkaTemplate.send(TOPIC + ".created", eventAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
