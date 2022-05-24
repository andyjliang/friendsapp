package io.andyliang.friendsapp.repos;

import io.andyliang.friendsapp.domain.FriendGroup;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FriendGroupRepository extends JpaRepository<FriendGroup, Long> {
}
