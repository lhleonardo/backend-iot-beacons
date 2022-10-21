package br.unicamp.iot.beacons.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class BeaconLocation {

    @Column(name = "location_name")
    private String name;

    @Column(name = "location_description")
    private String description;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

}
