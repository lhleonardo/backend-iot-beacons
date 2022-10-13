package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeaconTagNotFoundException extends RuntimeException{

    private static final String MESSAGE = "Invalid beacon's tag id: %d";

    public BeaconTagNotFoundException(Integer tagId) {
        super(String.format(MESSAGE, tagId));
    }
}
