package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateBeaconException extends RuntimeException {

    private static final String MESSAGE = "Beacon identifier already exists: %s";

    public DuplicateBeaconException(String identifier) {
        super(String.format(MESSAGE, identifier));
    }
}
