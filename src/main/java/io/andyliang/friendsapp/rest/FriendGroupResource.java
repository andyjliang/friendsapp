package io.andyliang.friendsapp.rest;

import io.andyliang.friendsapp.model.FriendGroupDTO;
import io.andyliang.friendsapp.service.FriendGroupService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/friendGroups", produces = MediaType.APPLICATION_JSON_VALUE)
public class FriendGroupResource {

    private final FriendGroupService friendGroupService;

    public FriendGroupResource(final FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }

    @GetMapping
    public ResponseEntity<List<FriendGroupDTO>> getAllFriendGroups() {
        return ResponseEntity.ok(friendGroupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FriendGroupDTO> getFriendGroup(@PathVariable final Long id) {
        return ResponseEntity.ok(friendGroupService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createFriendGroup(
            @RequestBody @Valid final FriendGroupDTO friendGroupDTO) {
        return new ResponseEntity<>(friendGroupService.create(friendGroupDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFriendGroup(@PathVariable final Long id,
            @RequestBody @Valid final FriendGroupDTO friendGroupDTO) {
        friendGroupService.update(id, friendGroupDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteFriendGroup(@PathVariable final Long id) {
        friendGroupService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
