package com.hs.demo01.dao.services;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.dao.AdminAuthDao;
import com.hs.demo01.dao.adminImp.AdminAuthImp;

import java.sql.SQLException;
import java.util.List;

public class AuthService {

    AdminAuthDao authDao = new AdminAuthImp();


    public List<AdminAuth> getAllAuths() throws Exception {
        return  authDao.selectAllAuths();
    }


    public  int addAuth(AdminAuth auth) throws Exception {

        return authDao.insertAuth(auth);
    }






}
