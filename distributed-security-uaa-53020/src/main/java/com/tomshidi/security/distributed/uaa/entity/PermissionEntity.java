package com.tomshidi.security.distributed.uaa.entity;

import java.io.Serializable;

/**
 * @author TomShiDi
 * @description
 * @date 2020-11-28 19:58:28
 **/
public class PermissionEntity implements Serializable {

    private String id;

    private String code;

    private String description;

    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
