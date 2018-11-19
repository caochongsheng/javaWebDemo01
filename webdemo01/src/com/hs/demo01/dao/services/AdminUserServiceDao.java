package com.hs.demo01.dao.services;

import com.hs.demo01.bean.admin.AdminUser;

import java.sql.SQLException;
import java.util.List;

public interface AdminUserServiceDao {

    /**
     * 获取后台管理员列表
     * @return
     */
    public List<AdminUser> getAdminUserList() throws  Exception;

    public  void addAdminUser(AdminUser adminUser) throws  Exception;

    public void  delAdminUser(AdminUser adminUser) throws  Exception;


    public void getAdminAdminister(AdminUser adminUser);



}
