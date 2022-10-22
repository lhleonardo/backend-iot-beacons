package br.unicamp.iot.beacons.backend.records;

import lombok.Data;

import java.util.List;

@Data
public class BeaconFilterRequest {
    private String type;
    private List<String> tags;
}
