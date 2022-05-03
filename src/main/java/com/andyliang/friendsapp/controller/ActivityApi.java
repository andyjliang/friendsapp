package com.andyliang.friendsapp.controller;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import com.andyliang.friendsapp.service.ActivityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups/activities")
public class ActivityApi {

    private ActivityService activityService;

    public ActivityApi(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActivitiesDto> createActivity() {
        return ResponseEntity.ok(activityService.createActivity());
    }

    @PatchMapping(value = "/{activityId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActivitiesDto> updateActivity(
            @RequestParam String done,
            @PathVariable(name = "activityId") String activityId) {
        return ResponseEntity.ok(activityService.updateActivity());
    }
}
