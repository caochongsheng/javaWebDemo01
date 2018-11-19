package com.hs.demo01.dao.adminImp;

import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.dao.AdminRoleDao;

import java.sql.SQLException;

public class AdminRoleImp implements AdminRoleDao {
    @Override
    public int insert(AdminRole role) throws SQLException {
        return 0;
    }

    @Override
    public AdminRole selectRoleById(String id) throws SQLException {
        return null;
    }
}
