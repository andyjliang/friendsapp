package com.andyliang.friendsapp.controller;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import com.andyliang.friendsapp.data.dto.GroupsDto;
import com.andyliang.friendsapp.service.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupApi {

    private GroupService groupService;

    public GroupApi(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupsDto> getGroups() {
        return ResponseEntity.ok(groupService.getGroups());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupsDto> createGroup() {
        return ResponseEntity.ok(groupService.createGroup());
    }

    @PatchMapping(value = "/{groupId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupsDto> updateGroup(@RequestParam String active) {
        return ResponseEntity.ok(groupService.toggleGroupActive());
    }

    @DeleteMapping(value = "/{groupId}")
    public ResponseEntity<Void> deleteGroup(
            @PathVariable(name = "groupId") String groupId) {
        groupService.deleteGroup();
        return ResponseEntity.ok().build();
    }
}
