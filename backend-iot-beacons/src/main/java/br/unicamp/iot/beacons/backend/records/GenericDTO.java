package br.unicamp.iot.beacons.backend.records;

public interface GenericDTO<Type> {
    Type toModel();
}
