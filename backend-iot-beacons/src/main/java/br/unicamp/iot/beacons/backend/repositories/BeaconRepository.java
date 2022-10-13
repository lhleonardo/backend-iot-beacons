package br.unicamp.iot.beacons.backend.repositories;

import br.unicamp.iot.beacons.backend.models.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {
}
