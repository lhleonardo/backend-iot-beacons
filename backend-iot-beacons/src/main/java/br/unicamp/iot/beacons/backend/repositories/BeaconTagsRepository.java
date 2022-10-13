package br.unicamp.iot.beacons.backend.repositories;

import br.unicamp.iot.beacons.backend.models.BeaconTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeaconTagsRepository extends JpaRepository<BeaconTag, Integer> {

    Optional<BeaconTag> findByName(String name);
}
