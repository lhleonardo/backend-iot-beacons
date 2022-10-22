package br.unicamp.iot.beacons.backend.repositories;

import br.unicamp.iot.beacons.backend.models.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Integer>, JpaSpecificationExecutor<Beacon> {
    Optional<Beacon> findByIdentifier(String identifier);
}
