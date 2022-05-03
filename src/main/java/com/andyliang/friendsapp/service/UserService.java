package com.andyliang.friendsapp.service;

import com.andyliang.friendsapp.data.dto.UsersDto;
import com.andyliang.friendsapp.data.repo.UsersRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    private UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersDto getUser(Integer userId) {
        Optional<UsersDto> optUser = usersRepository.findById(userId);
        if (optUser.isEmpty()) {
            throw new EntityNotFoundException(String.format("User with id %s not found", userId));
        }
        return optUser.get();
    }

    public UsersDto addUser(String name) {
        UsersDto usersDto = new UsersDto();
        usersDto.setName(name);
        return usersRepository.save(usersDto);
    }
}
