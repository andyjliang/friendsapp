package com.andyliang.friendsapp.service;

import com.andyliang.friendsapp.data.dto.GroupsDto;
import com.andyliang.friendsapp.data.repo.GroupsRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private GroupsRepository groupsRepository;

    public GroupService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    // TODO
    public GroupsDto getGroups() {
        return new GroupsDto();
    }

    // TODO
    public GroupsDto createGroup() {
        return new GroupsDto();
    }

    // TODO
    public GroupsDto toggleGroupActive() {
        return new GroupsDto();
    }

    // TODO
    public void deleteGroup() {

    }
}
