package com.hs.demo01.bean.admin;

import lombok.Data;

@Data
public class AdminRole {

    Integer id; // 角色id
    String name;  // 角色名称
    String role_desc; // 角色描述
    String auth_ids;  // 权限ids
    String role_auth_ac;  // 控制器-方法

}
