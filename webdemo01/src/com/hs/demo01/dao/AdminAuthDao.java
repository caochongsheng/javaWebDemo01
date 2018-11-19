package com.hs.demo01.dao;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.bean.admin.AdminRole;

import java.sql.SQLException;
import java.util.List;

public interface AdminAuthDao {

    // 获取权限列表
    List<AdminAuth> selectAllAuths() throws SQLException;

    // 获取一条权限 根据id
    AdminAuth selectOneAuth(Integer id) throws SQLException;

    // 添加一条 权限
    int insertAuth(AdminAuth auth) throws SQLException;

    // 更新一条 权限
    int updateAuth(AdminAuth auth) throws SQLException;


    List<AdminAuth> selectAuthsByRole(AdminRole adminRole) throws SQLException;




}
