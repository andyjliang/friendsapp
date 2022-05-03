package com.andyliang.friendsapp.data.repo;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends CrudRepository<ActivitiesDto, Integer> {
}
