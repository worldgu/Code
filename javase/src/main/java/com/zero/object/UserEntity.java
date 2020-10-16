package com.zero.object;

import lombok.Getter;
import lombok.ToString;

/**
 *@ClassName UserEntity
 *@Description TODO
 *@Author 张春海
 *@Date 2020/9/2 21:58 
 *@Version 1.0 */
@Getter
@ToString
public class UserEntity {

    String username;

    public UserEntity(){

    }

    public UserEntity ( String name ) {
        this.username = name;
    }




}
