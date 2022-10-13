package br.unicamp.iot.beacons.backend.controllers;

import br.unicamp.iot.beacons.backend.models.BeaconType;
import br.unicamp.iot.beacons.backend.records.CreateBeaconTypeRequest;
import br.unicamp.iot.beacons.backend.services.BeaconTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/types")
@Tag(name = "types", description = "Beacon type controller to manage available types")
public class BeaconTypeController {

    private final BeaconTypeService beaconTypeService;

    @PostMapping("/")
    @Operation(summary = "Create a new beacon type")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Successful operation")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public BeaconType create(
            @RequestBody
            @Valid
            @Parameter(name = "data", description = "data to create a new type")
            CreateBeaconTypeRequest request) {
        return this.beaconTypeService.create(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find type by id", description = "Returns a single type")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Invalid ID supplied")
    public ResponseEntity<BeaconType> findById(
            @PathVariable
            @Parameter(name = "id", description = "ID of type to return")
            Integer id) {

        Optional<BeaconType> result = this.beaconTypeService.findById(id);

        return ResponseEntity
                .status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(result.orElse(null));
    }

    @GetMapping("/")
    @Operation(summary = "Get all types without page")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<BeaconType> findAll() {
        return this.beaconTypeService.all();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete type by id")
    @ApiResponse(responseCode = "204", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Invalid ID supplied")
    public void delete(
            @PathVariable
            @Parameter(name = "id", description = "ID of type to delete")
            Integer id) {
        this.beaconTypeService.delete(id);
    }
}
