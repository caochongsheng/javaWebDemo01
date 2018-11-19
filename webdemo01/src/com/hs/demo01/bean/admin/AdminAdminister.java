package com.hs.demo01.bean.admin;

import lombok.Data;

import java.util.List;

@Data
public class AdminAdminister {

    AdminUser adminUser;

    List<AdminRole> roles;

    List<AdminAuth> privates ;


}
