package com.mask.demo.dataaccess.model.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRoleTest implements Serializable{

    private String id;

    private String userId;

    private String roleId;

}