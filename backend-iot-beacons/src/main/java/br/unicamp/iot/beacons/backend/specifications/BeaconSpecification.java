package br.unicamp.iot.beacons.backend.specifications;

import br.unicamp.iot.beacons.backend.models.Beacon;
import br.unicamp.iot.beacons.backend.models.BeaconTag;
import br.unicamp.iot.beacons.backend.records.BeaconFilterRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BeaconSpecification {

    public static Specification<Beacon> createFullSpecification(BeaconFilterRequest filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.isNull(filter)) {
                return criteriaBuilder.and(Collections.<Predicate>emptyList().toArray(Predicate[]::new));
            }
            if (Objects.nonNull(filter.getType())) {
                predicates.add(criteriaBuilder.equal(root.join("type").get("name"), filter.getType()));
            }

            if (Objects.nonNull(filter.getTags()) && !filter.getTags().isEmpty()) {
                Join<Beacon, BeaconTag> tags = root.join("details").join("tags");
                predicates.add(criteriaBuilder.in(tags.get("name")).value(filter.getTags()));
            }
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
