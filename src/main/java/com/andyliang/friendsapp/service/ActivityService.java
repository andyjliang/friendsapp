package com.andyliang.friendsapp.service;

import com.andyliang.friendsapp.data.dto.ActivitiesDto;
import com.andyliang.friendsapp.data.repo.ActivitiesRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private ActivitiesRepository activitiesRepository;

    public ActivityService(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    // TODO
    public ActivitiesDto createActivity() {
        return new ActivitiesDto();
    }

    // TODO
    public ActivitiesDto updateActivity() {
        return new ActivitiesDto();
    }
}
