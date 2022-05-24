package io.andyliang.friendsapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;


@Getter
@Setter
public class AppUserDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String fullname;

    @Size(max = 255)
    private String username;

    @Size(max = 255)
    private String passwordHash;

    private Long imageref;

    private OffsetDateTime dob;

}
