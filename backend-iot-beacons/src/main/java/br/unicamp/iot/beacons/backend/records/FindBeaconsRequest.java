package br.unicamp.iot.beacons.backend.records;

import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class FindBeaconsRequest {
    private BeaconFilterRequest filter;
    private Pageable page;
}
