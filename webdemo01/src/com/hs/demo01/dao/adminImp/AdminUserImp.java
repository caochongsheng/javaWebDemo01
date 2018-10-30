package com.hs.demo01.dao.adminImp;

import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminUserDao;

import java.sql.SQLException;
import java.util.List;

public class AdminUserImp implements AdminUserDao {

    @Override
    public int insertUser(AdminUser user) throws SQLException {
        return 0;
    }

    @Override
    public List<AdminUser> selectAllUser() throws SQLException {
        return null;
    }

    @Override
    public List<AdminRole> selectRolesByUser(AdminUser user) throws SQLException {
        return null;
    }

    @Override
    public int deleteRolesByUser(AdminUser user) throws SQLException {
        return 0;
    }

    @Override
    public int insertUserRole(AdminUser user, AdminRole role) {
        return 0;
    }

    @Override
    public AdminUser selectUserByNameAndPassword(String username, String password) {
        return null;
    }
}
