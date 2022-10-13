package br.unicamp.iot.beacons.backend.records;

import br.unicamp.iot.beacons.backend.models.BeaconType;

public record CreateBeaconTypeRequest(
        String name,
        String description
) implements GenericDTO<BeaconType> {

    @Override
    public BeaconType toModel() {
        BeaconType tag = new BeaconType();
        tag.setName(this.name);
        tag.setDescription(this.description);

        return tag;
    }

}
