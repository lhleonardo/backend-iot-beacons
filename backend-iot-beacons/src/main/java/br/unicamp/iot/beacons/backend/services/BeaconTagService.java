package br.unicamp.iot.beacons.backend.services;

import br.unicamp.iot.beacons.backend.exceptions.BeaconTagNotFoundException;
import br.unicamp.iot.beacons.backend.models.BeaconTag;
import br.unicamp.iot.beacons.backend.records.CreateBeaconTagRequest;
import br.unicamp.iot.beacons.backend.repositories.BeaconTagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeaconTagService {

    private final BeaconTagsRepository beaconTagsRepository;

    public BeaconTag create(CreateBeaconTagRequest request) {
        return this.beaconTagsRepository.save(request.toModel());
    }

    public List<BeaconTag> all() {
        return this.beaconTagsRepository.findAll();
    }

    public Optional<BeaconTag> findById(Integer tagId) {
        return this.beaconTagsRepository.findById(tagId);
    }

    public void delete(Integer tagId) {
        boolean tagExists = this.beaconTagsRepository.existsById(tagId);

        if (!tagExists) {
            throw new BeaconTagNotFoundException(tagId);
        }

        this.beaconTagsRepository.deleteById(tagId);
    }
}
