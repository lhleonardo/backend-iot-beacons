package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeaconTypeNotFoundException extends RuntimeException{

    private static final String MESSAGE = "Invalid beacon's type id: %d";

    public BeaconTypeNotFoundException(Integer tagId) {
        super(String.format(MESSAGE, tagId));
    }
}
