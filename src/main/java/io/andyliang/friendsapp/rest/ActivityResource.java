package io.andyliang.friendsapp.rest;

import io.andyliang.friendsapp.model.ActivityDTO;
import io.andyliang.friendsapp.service.ActivityService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/activitys", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivityResource {

    private final ActivityService activityService;

    public ActivityResource(final ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivitys() {
        return ResponseEntity.ok(activityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable final Long id) {
        return ResponseEntity.ok(activityService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createActivity(@RequestBody @Valid final ActivityDTO activityDTO) {
        return new ResponseEntity<>(activityService.create(activityDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateActivity(@PathVariable final Long id,
            @RequestBody @Valid final ActivityDTO activityDTO) {
        activityService.update(id, activityDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteActivity(@PathVariable final Long id) {
        activityService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
