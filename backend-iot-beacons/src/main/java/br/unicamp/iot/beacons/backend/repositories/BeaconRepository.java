package br.unicamp.iot.beacons.backend.repositories;

import br.unicamp.iot.beacons.backend.models.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {
    Optional<Beacon> findByUuid(UUID uuid);
}
