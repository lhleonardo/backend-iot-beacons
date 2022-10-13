package br.unicamp.iot.beacons.backend.models;

import javax.persistence.*;

@Embeddable
public class BeaconDetails {

    @Embedded()
    private BeaconLocation beaconLocation;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private BeaconTag tag;
}
