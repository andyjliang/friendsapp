package com.andyliang.friendsapp.data.repo;

import com.andyliang.friendsapp.data.dto.UsersDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersDto, Integer> {
}
