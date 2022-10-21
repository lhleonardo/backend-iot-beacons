package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateBeaconException extends RuntimeException {

    private static final String MESSAGE = "Beacon uuid already exists: %s";

    public DuplicateBeaconException(UUID uuid) {
        super(String.format(MESSAGE, uuid.toString()));
    }
}
