package br.unicamp.iot.beacons.backend.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Beacon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private UUID uuid;

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
