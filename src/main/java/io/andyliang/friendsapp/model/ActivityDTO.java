package io.andyliang.friendsapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class ActivityDTO {

    private Long id;

    @NotNull
    private Boolean done;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    private Long friendgroup;

}
