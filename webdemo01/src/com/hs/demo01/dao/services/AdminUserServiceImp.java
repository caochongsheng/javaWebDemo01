package com.hs.demo01.dao.services;

import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminRoleDao;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.dao.adminImp.AdminUserImp;

import java.sql.SQLException;
import java.util.List;

public class AdminUserServiceImp  implements AdminUserServiceDao {

    AdminUserDao adminUserDao = new AdminUserImp();

    @Override
    public List<AdminUser> getAdminUserList() throws Exception {

        return adminUserDao.selectAllUser();
    }

    @Override
    public void addAdminUser(AdminUser adminUser) throws Exception {

        adminUserDao.insertUser(adminUser);
    }

    @Override
    public void delAdminUser(AdminUser adminUser) throws Exception {
        adminUserDao.deleteAdminUserById(adminUser.getId());
    }

    @Override
    public void getAdminAdminister(AdminUser adminUser) {



    }
}
