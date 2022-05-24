package io.andyliang.friendsapp.service;

import io.andyliang.friendsapp.domain.Activity;
import io.andyliang.friendsapp.domain.FriendGroup;
import io.andyliang.friendsapp.model.ActivityDTO;
import io.andyliang.friendsapp.repos.ActivityRepository;
import io.andyliang.friendsapp.repos.FriendGroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final FriendGroupRepository friendGroupRepository;

    public ActivityService(final ActivityRepository activityRepository,
            final FriendGroupRepository friendGroupRepository) {
        this.activityRepository = activityRepository;
        this.friendGroupRepository = friendGroupRepository;
    }

    public List<ActivityDTO> findAll() {
        return activityRepository.findAll()
                .stream()
                .map(activity -> mapToDTO(activity, new ActivityDTO()))
                .collect(Collectors.toList());
    }

    public ActivityDTO get(final Long id) {
        return activityRepository.findById(id)
                .map(activity -> mapToDTO(activity, new ActivityDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ActivityDTO activityDTO) {
        final Activity activity = new Activity();
        mapToEntity(activityDTO, activity);
        return activityRepository.save(activity).getId();
    }

    public void update(final Long id, final ActivityDTO activityDTO) {
        final Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(activityDTO, activity);
        activityRepository.save(activity);
    }

    public void delete(final Long id) {
        activityRepository.deleteById(id);
    }

    private ActivityDTO mapToDTO(final Activity activity, final ActivityDTO activityDTO) {
        activityDTO.setId(activity.getId());
        activityDTO.setDone(activity.getDone());
        activityDTO.setName(activity.getName());
        activityDTO.setFriendgroup(activity.getFriendgroup() == null ? null : activity.getFriendgroup().getId());
        return activityDTO;
    }

    private Activity mapToEntity(final ActivityDTO activityDTO, final Activity activity) {
        activity.setDone(activityDTO.getDone());
        activity.setName(activityDTO.getName());
        if (activityDTO.getFriendgroup() != null && (activity.getFriendgroup() == null || !activity.getFriendgroup().getId().equals(activityDTO.getFriendgroup()))) {
            final FriendGroup friendgroup = friendGroupRepository.findById(activityDTO.getFriendgroup())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "friendgroup not found"));
            activity.setFriendgroup(friendgroup);
        }
        return activity;
    }

}
