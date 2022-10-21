package br.unicamp.iot.beacons.backend.controllers;

import br.unicamp.iot.beacons.backend.models.Beacon;
import br.unicamp.iot.beacons.backend.records.CreateBeaconRequest;
import br.unicamp.iot.beacons.backend.services.BeaconService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "beacon")
@RequiredArgsConstructor
@RequestMapping("/beacons")
public class BeaconController {

    private final BeaconService beaconService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Creates a new beacon")
    @ApiResponse(responseCode = "201", description = "Beacon created")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public Beacon create(@RequestBody CreateBeaconRequest request) {
        return this.beaconService.create(request);
    }
}
