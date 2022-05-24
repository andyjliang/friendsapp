package io.andyliang.friendsapp.repos;

import io.andyliang.friendsapp.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
