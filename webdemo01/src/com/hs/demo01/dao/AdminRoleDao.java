package com.hs.demo01.dao;

import com.hs.demo01.bean.admin.AdminRole;

import java.sql.SQLException;

public interface AdminRoleDao {

    int insert(AdminRole role) throws SQLException;

    AdminRole selectRoleById(String id) throws SQLException;


}
