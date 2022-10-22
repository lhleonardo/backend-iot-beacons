package br.unicamp.iot.beacons.backend.controllers;

import br.unicamp.iot.beacons.backend.models.Beacon;
import br.unicamp.iot.beacons.backend.records.BeaconFilterRequest;
import br.unicamp.iot.beacons.backend.records.CreateBeaconRequest;
import br.unicamp.iot.beacons.backend.services.BeaconService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "beacon", description = "Beacon controller to manage all beacons")
@RequiredArgsConstructor
@RequestMapping("/beacons")
public class BeaconController {

    private final BeaconService beaconService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new beacon")
    @ApiResponse(responseCode = "201", description = "Beacon created")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public Beacon create(@RequestBody CreateBeaconRequest request) {
        return this.beaconService.create(request);
    }

    @GetMapping("/{identifier}")
    @Operation(summary = "Find beacon by identifier")
    @ApiResponse(responseCode = "200", description = "Beacon exists")
    @ApiResponse(responseCode = "404", description = "Beacon not found", content = @Content)
    public ResponseEntity<Beacon> findByIdentifier(@PathVariable("identifier") String identifier) {
        Optional<Beacon> beacon = this.beaconService.findByIdentifier(identifier);

        return ResponseEntity
                .status(beacon.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(beacon.orElse(null));
    }

    @GetMapping("/")
    @Operation(
            summary = "Search beacons by filter, page and sort configs",
            description = "Find all beacons by filter and page configs. Note: all parameters need to pass in query params.")
    @ApiResponse(responseCode = "200", description = "Beacons")
    public Page<Beacon> findAllBeacons(
            @RequestParam(required = false) @ParameterObject BeaconFilterRequest request,
            @ParameterObject @PageableDefault(size = 20, sort = {"id"}) Pageable page) {
        return this.beaconService.findAll(request, page);
    }
}
