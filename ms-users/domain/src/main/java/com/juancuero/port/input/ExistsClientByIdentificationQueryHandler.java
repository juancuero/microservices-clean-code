package com.juancuero.port.input;
import java.util.UUID;

public interface ExistsClientByIdentificationQueryHandler {
    boolean execute(String identification);
}