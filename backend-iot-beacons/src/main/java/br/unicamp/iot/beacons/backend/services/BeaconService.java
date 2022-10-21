package br.unicamp.iot.beacons.backend.services;

import br.unicamp.iot.beacons.backend.exceptions.DuplicateBeaconException;
import br.unicamp.iot.beacons.backend.models.Beacon;
import br.unicamp.iot.beacons.backend.models.BeaconDetails;
import br.unicamp.iot.beacons.backend.models.BeaconTag;
import br.unicamp.iot.beacons.backend.models.BeaconType;
import br.unicamp.iot.beacons.backend.records.CreateBeaconRequest;
import br.unicamp.iot.beacons.backend.repositories.BeaconRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeaconService {

    private final BeaconTagService beaconTagService;
    private final BeaconTypeService beaconTypeService;
    private final BeaconRepository beaconRepository;


    public Beacon create(CreateBeaconRequest request) {
        if (this.findByUuid(UUID.fromString(request.uuid())).isPresent()) {
            throw new DuplicateBeaconException(UUID.fromString(request.uuid()));
        }

        List<BeaconTag> tags = request.tags().stream()
                .map(this.beaconTagService::findByTagName)
                .toList();

        BeaconType type = this.beaconTypeService.findByName(request.type());

        BeaconDetails details = new BeaconDetails();
        details.setTag(tags);
        details.setBeaconLocation(request.location().toModel());


        Beacon beacon = new Beacon();
        beacon.setUuid(UUID.fromString(request.uuid()));
        beacon.setName(request.name());
        beacon.setCreatedAt(LocalDateTime.now());
        beacon.setUpdatedAt(null);
        beacon.setType(type);

        beacon.setDetails(details);

        return this.beaconRepository.save(beacon);
    }

    public Optional<Beacon> findByUuid(UUID uuid) {
        return this.beaconRepository.findByUuid(uuid);
    }
}
