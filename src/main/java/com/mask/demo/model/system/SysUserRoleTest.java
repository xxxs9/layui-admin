package com.mask.demo.model.system;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mac
 * @description: TODO
 * @date: 2020-02-25 17:53
 */
@Data
public class SysUserRoleTest implements Serializable{

    private String id;

    private String userId;

    private String roleId;

}