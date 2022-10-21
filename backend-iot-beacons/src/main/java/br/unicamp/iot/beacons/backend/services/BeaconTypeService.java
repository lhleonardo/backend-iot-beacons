package br.unicamp.iot.beacons.backend.services;

import br.unicamp.iot.beacons.backend.exceptions.BeaconTypeNotFoundException;
import br.unicamp.iot.beacons.backend.models.BeaconType;
import br.unicamp.iot.beacons.backend.records.CreateBeaconTypeRequest;
import br.unicamp.iot.beacons.backend.repositories.BeaconTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeaconTypeService {

    private final BeaconTypeRepository beaconTypeRepository;

    public BeaconType create(CreateBeaconTypeRequest request) {
        return this.beaconTypeRepository.save(request.toModel());
    }

    public List<BeaconType> all() {
        return this.beaconTypeRepository.findAll();
    }

    public Optional<BeaconType> findById(Integer tagId) {
        return this.beaconTypeRepository.findById(tagId);
    }

    public BeaconType findByName(String name) {
        return this.beaconTypeRepository.findByName(name).orElseThrow(() -> new BeaconTypeNotFoundException(name));
    }

    public void delete(Integer tagId) {
        boolean tagExists = this.beaconTypeRepository.existsById(tagId);

        if (!tagExists) {
            throw new BeaconTypeNotFoundException(tagId);
        }

        this.beaconTypeRepository.deleteById(tagId);
    }
}
