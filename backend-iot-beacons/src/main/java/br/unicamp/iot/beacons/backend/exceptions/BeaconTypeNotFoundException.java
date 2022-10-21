package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeaconTypeNotFoundException extends RuntimeException{

    private static final String MESSAGE_ID = "Invalid beacon's type id: %d";
    private static final String MESSAGE_NAME = "Invalid beacon's type name: %s";

    public BeaconTypeNotFoundException(Integer tagId) {
        super(String.format(MESSAGE_ID, tagId));
    }

    public BeaconTypeNotFoundException(String name) {
        super(String.format(MESSAGE_NAME, name));
    }
}
