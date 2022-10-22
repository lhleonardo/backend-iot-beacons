package br.unicamp.iot.beacons.backend.records;

import java.util.List;

public record CreateBeaconRequest(
        String name,
        String identifier,
        String type,
        List<String> tags,
        LocationDTO location
) {}
