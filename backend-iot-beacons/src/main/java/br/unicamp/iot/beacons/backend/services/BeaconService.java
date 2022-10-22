package br.unicamp.iot.beacons.backend.services;

import br.unicamp.iot.beacons.backend.exceptions.DuplicateBeaconException;
import br.unicamp.iot.beacons.backend.models.Beacon;
import br.unicamp.iot.beacons.backend.models.BeaconDetails;
import br.unicamp.iot.beacons.backend.models.BeaconTag;
import br.unicamp.iot.beacons.backend.models.BeaconType;
import br.unicamp.iot.beacons.backend.records.BeaconFilterRequest;
import br.unicamp.iot.beacons.backend.records.CreateBeaconRequest;
import br.unicamp.iot.beacons.backend.repositories.BeaconRepository;
import br.unicamp.iot.beacons.backend.specifications.BeaconSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeaconService {

    private final BeaconTagService beaconTagService;
    private final BeaconTypeService beaconTypeService;
    private final BeaconRepository beaconRepository;


    public Beacon create(CreateBeaconRequest request) {
        if (this.findByIdentifier(request.identifier()).isPresent()) {
            throw new DuplicateBeaconException(request.identifier());
        }

        List<BeaconTag> tags = request.tags().stream()
                .map(this.beaconTagService::findByTagName)
                .toList();

        BeaconType type = this.beaconTypeService.findByName(request.type());

        BeaconDetails details = new BeaconDetails();
        details.setTag(tags);
        details.setBeaconLocation(request.location().toModel());


        Beacon beacon = new Beacon();
        beacon.setIdentifier(request.identifier());
        beacon.setName(request.name());
        beacon.setCreatedAt(LocalDateTime.now());
        beacon.setUpdatedAt(null);
        beacon.setType(type);

        beacon.setDetails(details);

        return this.beaconRepository.save(beacon);
    }

    public Optional<Beacon> findByIdentifier(String identifier) {
        return this.beaconRepository.findByIdentifier(identifier);
    }

    public Page<Beacon> findAll(BeaconFilterRequest filter, Pageable page) {
        return this.beaconRepository.findAll(BeaconSpecification.createFullSpecification(filter), page);
    }
}
