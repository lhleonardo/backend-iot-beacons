package br.unicamp.iot.beacons.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "beacons")
@Getter
@Setter
public class Beacon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private UUID uuid;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BeaconType type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Embedded
    private BeaconDetails details;

}
