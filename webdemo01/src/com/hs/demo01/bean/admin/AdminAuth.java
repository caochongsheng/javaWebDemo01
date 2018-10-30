package com.hs.demo01.bean.admin;

import lombok.Data;

@Data
public class AdminAuth {

    Integer id;
    String name;
    String pid;
    String controler;
    String action;
    String path;
    String auth_level;
}
