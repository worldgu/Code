package com.zero.socket;/**
 * Created by 张春海 on 2020/6/13  23:41
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *@ClassName User
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/13 23:41 
 *@Version 1.0 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    static final long serialVersionUID = 12456789L;

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
