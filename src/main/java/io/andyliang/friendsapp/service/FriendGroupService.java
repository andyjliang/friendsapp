package io.andyliang.friendsapp.service;

import io.andyliang.friendsapp.domain.AppUser;
import io.andyliang.friendsapp.domain.FriendGroup;
import io.andyliang.friendsapp.model.FriendGroupDTO;
import io.andyliang.friendsapp.repos.AppUserRepository;
import io.andyliang.friendsapp.repos.FriendGroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class FriendGroupService {

    private final FriendGroupRepository friendGroupRepository;
    private final AppUserRepository appUserRepository;

    public FriendGroupService(final FriendGroupRepository friendGroupRepository,
            final AppUserRepository appUserRepository) {
        this.friendGroupRepository = friendGroupRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<FriendGroupDTO> findAll() {
        return friendGroupRepository.findAll()
                .stream()
                .map(friendGroup -> mapToDTO(friendGroup, new FriendGroupDTO()))
                .collect(Collectors.toList());
    }

    public FriendGroupDTO get(final Long id) {
        return friendGroupRepository.findById(id)
                .map(friendGroup -> mapToDTO(friendGroup, new FriendGroupDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FriendGroupDTO friendGroupDTO) {
        final FriendGroup friendGroup = new FriendGroup();
        mapToEntity(friendGroupDTO, friendGroup);
        return friendGroupRepository.save(friendGroup).getId();
    }

    public void update(final Long id, final FriendGroupDTO friendGroupDTO) {
        final FriendGroup friendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(friendGroupDTO, friendGroup);
        friendGroupRepository.save(friendGroup);
    }

    public void delete(final Long id) {
        friendGroupRepository.deleteById(id);
    }

    private FriendGroupDTO mapToDTO(final FriendGroup friendGroup,
            final FriendGroupDTO friendGroupDTO) {
        friendGroupDTO.setId(friendGroup.getId());
        friendGroupDTO.setImageref(friendGroup.getImageref());
        friendGroupDTO.setGroupname(friendGroup.getGroupname());
        friendGroupDTO.setActive(friendGroup.getActive());
        friendGroupDTO.setUserGroups(friendGroup.getUserGroupAppUsers() == null ? null : friendGroup.getUserGroupAppUsers().stream()
                .map(appUser -> appUser.getId())
                .collect(Collectors.toList()));
        return friendGroupDTO;
    }

    private FriendGroup mapToEntity(final FriendGroupDTO friendGroupDTO,
            final FriendGroup friendGroup) {
        friendGroup.setImageref(friendGroupDTO.getImageref());
        friendGroup.setGroupname(friendGroupDTO.getGroupname());
        friendGroup.setActive(friendGroupDTO.getActive());
        if (friendGroupDTO.getUserGroups() != null) {
            final List<AppUser> userGroups = appUserRepository.findAllById(friendGroupDTO.getUserGroups());
            if (userGroups.size() != friendGroupDTO.getUserGroups().size()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of userGroups not found");
            }
            friendGroup.setUserGroupAppUsers(userGroups.stream().collect(Collectors.toSet()));
        }
        return friendGroup;
    }

}
