package br.unicamp.iot.beacons.backend.controllers;

import br.unicamp.iot.beacons.backend.models.BeaconTag;
import br.unicamp.iot.beacons.backend.records.CreateBeaconTagRequest;
import br.unicamp.iot.beacons.backend.services.BeaconTagService;
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
@RequestMapping("/tags")
@Tag(name = "tags", description = "Beacon tag controller to manage available tags")
public class BeaconTagsController {

    private final BeaconTagService beaconTagService;

    @PostMapping("/")
    @Operation(summary = "Create a new tag")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Successful operation")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public BeaconTag create(
            @RequestBody
            @Valid
            @Parameter(name = "data", description = "data to create a new tag")
            CreateBeaconTagRequest request) {
        return this.beaconTagService.create(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find tag by id", description = "Returns a single tag")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Invalid ID supplied")
    public ResponseEntity<BeaconTag> findById(
            @PathVariable
            @Parameter(name = "id", description = "ID of tag to return")
            Integer id) {

        Optional<BeaconTag> result = this.beaconTagService.findById(id);

        return ResponseEntity
                .status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(result.orElse(null));
    }

    @GetMapping("/")
    @Operation(summary = "Get all tags without page")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<BeaconTag> findAll() {
        return this.beaconTagService.all();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete tag by id")
    @ApiResponse(responseCode = "204", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Invalid ID supplied")
    public void delete(
            @PathVariable
            @Parameter(name = "id", description = "ID of tag to delete")
            Integer id) {
        this.beaconTagService.delete(id);
    }
}
