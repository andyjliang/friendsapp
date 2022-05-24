package io.andyliang.friendsapp.service;

import io.andyliang.friendsapp.domain.AppUser;
import io.andyliang.friendsapp.model.AppUserDTO;
import io.andyliang.friendsapp.repos.AppUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(final AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUserDTO> findAll() {
        return appUserRepository.findAll()
                .stream()
                .map(appUser -> mapToDTO(appUser, new AppUserDTO()))
                .collect(Collectors.toList());
    }

    public AppUserDTO get(final Long id) {
        return appUserRepository.findById(id)
                .map(appUser -> mapToDTO(appUser, new AppUserDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final AppUserDTO appUserDTO) {
        final AppUser appUser = new AppUser();
        mapToEntity(appUserDTO, appUser);
        return appUserRepository.save(appUser).getId();
    }

    public void update(final Long id, final AppUserDTO appUserDTO) {
        final AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(appUserDTO, appUser);
        appUserRepository.save(appUser);
    }

    public void delete(final Long id) {
        appUserRepository.deleteById(id);
    }

    private AppUserDTO mapToDTO(final AppUser appUser, final AppUserDTO appUserDTO) {
        appUserDTO.setId(appUser.getId());
        appUserDTO.setFullname(appUser.getFullname());
        appUserDTO.setUsername(appUser.getUsername());
        appUserDTO.setPasswordHash(appUser.getPasswordHash());
        appUserDTO.setImageref(appUser.getImageref());
        appUserDTO.setDob(appUser.getDob());
        return appUserDTO;
    }

    private AppUser mapToEntity(final AppUserDTO appUserDTO, final AppUser appUser) {
        appUser.setFullname(appUserDTO.getFullname());
        appUser.setUsername(appUserDTO.getUsername());
        appUser.setPasswordHash(appUserDTO.getPasswordHash());
        appUser.setImageref(appUserDTO.getImageref());
        appUser.setDob(appUserDTO.getDob());
        return appUser;
    }

}
