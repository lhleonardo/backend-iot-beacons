package br.unicamp.iot.beacons.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeaconTagNotFoundException extends RuntimeException{

    private static final String MESSAGE_TAG_ID = "Invalid beacon's tag id: %d";
    private static final String MESSAGE_TAG_NAME = "Invalid beacon's tag name: %s";

    public BeaconTagNotFoundException(Integer tagId) {
        super(String.format(MESSAGE_TAG_ID, tagId));
    }

    public BeaconTagNotFoundException(String tagName) {
        super(String.format(MESSAGE_TAG_NAME, tagName));
    }
}
