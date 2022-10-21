package br.unicamp.iot.beacons.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Data
@NoArgsConstructor
public class BeaconDetails {

    @Embedded()
    private BeaconLocation beaconLocation;

    @ManyToMany
    @JoinTable(
            name = "beacon_tags",
            joinColumns = @JoinColumn(name = "beacon_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<BeaconTag> tag;
}
