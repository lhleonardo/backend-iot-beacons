package br.unicamp.iot.beacons.backend.records;

import br.unicamp.iot.beacons.backend.models.BeaconTag;

public record CreateBeaconTagRequest(
        String name,
        String description
) implements GenericDTO<BeaconTag> {

    @Override
    public BeaconTag toModel() {
        BeaconTag tag = new BeaconTag();
        tag.setName(this.name);
        tag.setDescription(this.description);

        return tag;
    }

}
