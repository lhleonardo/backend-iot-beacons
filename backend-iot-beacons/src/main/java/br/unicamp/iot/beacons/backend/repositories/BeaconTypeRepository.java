package br.unicamp.iot.beacons.backend.repositories;

import br.unicamp.iot.beacons.backend.models.BeaconType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeaconTypeRepository extends JpaRepository<BeaconType, Integer> {

    Optional<BeaconType> findByName(String name);
}
