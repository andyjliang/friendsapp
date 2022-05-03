package com.andyliang.friendsapp.controller;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import com.andyliang.friendsapp.data.dto.GroupsDto;
import com.andyliang.friendsapp.data.dto.UsersDto;
import com.andyliang.friendsapp.request.UserRequest;
import com.andyliang.friendsapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserApi {

    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> getUser(@PathVariable(name = "userId") Integer userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> addUser(@RequestBody UserRequest userRequest) {
        String name = userRequest.getName();
        return ResponseEntity.ok(userService.addUser(name));
    }
}
