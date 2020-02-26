package com.mask.demo.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mac
 * @description: TODO
 * @date: 2020-02-25 17:52
 */
@Data
public class SysAccessPermissionTest implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String url;

    private String roles;

    private int sort;

    private String isDeleted;

    private String createUser;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String updateUser;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}