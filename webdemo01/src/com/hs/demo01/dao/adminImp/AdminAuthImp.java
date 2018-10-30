package com.hs.demo01.dao.adminImp;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.dao.AdminAuthDao;

import java.sql.SQLException;
import java.util.List;

public class AdminAuthImp implements AdminAuthDao {
    @Override
    public List<AdminAuth> selectAllAuths() throws SQLException {

        return null;
    }

    @Override
    public AdminAuth selectOneAuth(Integer id) throws SQLException {
        return null;
    }

    @Override
    public int insertAuth(AdminAuth auth) throws SQLException {
        return 0;
    }

    @Override
    public int updateAuth(AdminAuth auth) throws SQLException {
        return 0;
    }
}
