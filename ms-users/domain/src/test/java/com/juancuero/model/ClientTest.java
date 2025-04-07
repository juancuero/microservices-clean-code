package com.juancuero.model;

import com.juancuero.model.enums.ClientStatus;
import com.juancuero.model.enums.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    public void testClientCreation() {
        Person person = Person.builder()
                .name("Juan Cuero")
                .gender(Gender.M)
                .age(29)
                .identification("1121924150")
                .address("Calle falsa 123")
                .phone("313000000")
                .build();

        Client client = Client.builder()
                .person(person)
                .password("password123")
                .status(ClientStatus.ACTIVE)
                .build();

        assertEquals("Juan Cuero", client.getPerson().getName());
        assertEquals(Gender.M, client.getPerson().getGender());
        assertEquals(29, client.getPerson().getAge());
        assertEquals("password123", client.getPassword());
        assertEquals(ClientStatus.ACTIVE, client.getStatus());
    }
}
