package com.hs.demo01.admin;

import lombok.Data;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

@Data
public class User {
    private String title;
    private String img;
    private String score;
    private String actor;
    private String roles;
    private String playurl;
    private String is_online;
    private String createtime;
    private String desc;


}
