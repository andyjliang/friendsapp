package io.andyliang.friendsapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class FriendGroupDTO {

    private Long id;

    private Long imageref;

    @NotNull
    @Size(max = 255)
    private String groupname;

    @NotNull
    private Boolean active;

    private List<Long> userGroups;

}
