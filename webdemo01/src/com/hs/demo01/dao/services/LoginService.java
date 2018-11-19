package com.hs.demo01.dao.services;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminAuthDao;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.dao.adminImp.AdminAuthImp;
import com.hs.demo01.dao.adminImp.AdminUserImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginService {

    AdminUserDao adminUserDao = new AdminUserImp();

      public AdminUser login(String username ,String password) throws Exception {
              AdminUser user = new AdminUser();
              user.setPwd(password);
              user.setName(username);
           return adminUserDao.selectAdminUser(user);
       }


       public List<AdminAuth> getAuthsByAdminUser(AdminUser adminUser) throws Exception {
           List<AdminAuth> auths = new ArrayList<AdminAuth>();
          if(adminUser.getName().equals("admin")){ // 总管理员

              AdminAuthDao authDao = new AdminAuthImp();
              auths = authDao.selectAllAuths();


          }else {
              List<AdminRole> roles  = adminUserDao.selectRolesByUser(adminUser);

              AdminAuthDao authDao = new AdminAuthImp();
              for (int i = 0; i < roles.size(); i++) {
                  List<AdminAuth> list = authDao.selectAuthsByRole(roles.get(i));
                  for (int j = 0; j < list.size(); j++) {
                      if(!auths.contains(list.get(j))){  // 去重
                          auths.add(list.get(j));
                      }
                  }
              }
          }



            return auths;
       }


    /**
     * 获取首页左边菜单栏数据
     * @param
     * @return
     */
       public Map<AdminAuth,List<AdminAuth>> getHomeMenus(AdminUser adminUser) throws Exception {
           List<AdminAuth> auths =getAuthsByAdminUser(adminUser);
           Map<AdminAuth,List<AdminAuth>> maneu = new HashMap<AdminAuth, List<AdminAuth>>();
           for (int i = 0; i < auths.size(); i++) {

               if(auths.get(i).getPid() == 0){
                   List<AdminAuth>  childAuths = new ArrayList<AdminAuth>();

                   for (int j = 0; j < auths.size(); j++) {
                       if(auths.get(j) .getPid() ==  auths.get(i).getId()){
                           childAuths.add(auths.get(j));
                       }
                   }

                   maneu.put(auths.get(i),childAuths);

               }


           }


           return maneu;

       }





}
