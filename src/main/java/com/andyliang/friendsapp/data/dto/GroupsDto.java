package com.andyliang.friendsapp.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
