package br.unicamp.iot.beacons.backend.records;

import br.unicamp.iot.beacons.backend.models.BeaconLocation;

public record LocationDTO(
        String name,
        String description,
        double latitude,
        double longitude
) implements GenericDTO<BeaconLocation> {
    @Override
    public BeaconLocation toModel() {
        BeaconLocation location = new BeaconLocation();
        location.setName(name);
        location.setDescription(description);
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        return location;
    }
}
