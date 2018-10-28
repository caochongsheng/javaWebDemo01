package com.hs.demo01.dao;

import com.hs.demo01.admin.User;
import lombok.Data;

import java.sql.SQLException;

/**
 * Created by shengcaochong on 2018/10/21.
 */
public interface UserDao {

//    void userRegist(User user)throws SQLException;
//
//    User userActive(String code)throws SQLException;
//
//    void updateUser(User user)throws SQLException;
//
//    User userLogin(User user)throws SQLException;

    // 用户注册
    void userRegist(User user) throws SQLException;


}
