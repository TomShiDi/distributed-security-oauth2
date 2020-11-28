package com.tomshidi.security.distributed.uaa.entity;

import java.io.Serializable;

/**
 * @author TomShiDi
 * @description
 * @date 2020-11-28 19:58:39
 **/
public class UserEntity implements Serializable {

    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
