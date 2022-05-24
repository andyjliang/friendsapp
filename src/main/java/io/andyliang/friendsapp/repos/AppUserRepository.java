package io.andyliang.friendsapp.repos;

import io.andyliang.friendsapp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
