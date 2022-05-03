package com.andyliang.friendsapp.data.repo;

import com.andyliang.friendsapp.data.dto.GroupsDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends CrudRepository<GroupsDto, Integer> {
}
