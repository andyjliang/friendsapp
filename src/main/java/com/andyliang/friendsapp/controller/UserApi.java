package com.andyliang.friendsapp.controller;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import com.andyliang.friendsapp.data.dto.GroupsDto;
import com.andyliang.friendsapp.data.dto.UsersDto;
import com.andyliang.friendsapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class UserApi {

    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<UsersDto> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping()
    public ResponseEntity<UsersDto> addUser() {
        return ResponseEntity.ok(userService.addUser());
    }
}
