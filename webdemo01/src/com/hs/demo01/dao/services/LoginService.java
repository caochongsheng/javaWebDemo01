package com.hs.demo01.dao.services;

import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.dao.adminImp.AdminUserImp;

import java.sql.SQLException;

public class LoginService {

    AdminUserDao adminUserDao = new AdminUserImp();

      public AdminUser login(String username ,String password) throws Exception {
              AdminUser user = new AdminUser();
              user.setPwd(password);
              user.setName(username);
           return adminUserDao.selectAdminUser(user);
       }

       public boolean loginOut(AdminUser adminUser){



          return false;
       }



}
