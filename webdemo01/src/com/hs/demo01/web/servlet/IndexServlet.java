package com.hs.demo01.web.servlet;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.dao.MovieDao;
import com.hs.demo01.dao.adminImp.AdminUserImp;
import com.hs.demo01.dao.daoimp.MovieDaoImp;
import com.hs.demo01.dao.services.LoginService;
import com.hs.demo01.utils.MD5Utils;
import com.hs.demo01.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by shengcaochong on 2018/10/20.
 */
public class IndexServlet extends BaseServlet {

    // 默认方法
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String method = req.getParameter("method");

        System.out.println("execute-----------"+method);
        return "/views/admin/main.jsp";
    }

    public String index(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("index-----------");
        Map<String, String[]> map =   req.getParameterMap();

        Movie user = new Movie();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());

        List<AdminUser> adminUsers = null;

        AdminUserDao adminUserDao = new AdminUserImp();
        try {
            adminUsers = adminUserDao.selectAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (adminUsers != null) {
            System.out.println(adminUsers);
        }

        req.getSession().setAttribute("path", "views/admin/authList.jsp");
        req.getSession().setAttribute("adminUsers", adminUsers);

        return "/views/admin/main.jsp";
    }


    public String getUserList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> map =   req.getParameterMap();

        Movie user = new Movie();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());

        List<AdminUser> adminUsers = null;

        AdminUserDao adminUserDao = new AdminUserImp();
        try {
            adminUsers = adminUserDao.selectAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (adminUsers != null) {
            System.out.println(adminUsers);
        }
        req.getSession().setAttribute("adminUsers", adminUsers);

        return "views/admin/authList.jsp";
    }







    public String addAdminUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {

        Map<String, String[]> map =   req.getParameterMap();
        AdminUser user = new AdminUser();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdminUserDao adminUserDao = new AdminUserImp();

            int  result = adminUserDao.insertUser(user) ;
            if(result == 1){
                System.out.println("添加用户成功");
                List<AdminUser> adminUsers = null;
                try {
                    adminUsers = adminUserDao.selectAllUser();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                if (adminUsers != null) {
                    System.out.println(adminUsers);
                }
                req.getSession().setAttribute("adminUsers", adminUsers);

                return "views/admin/authList.jsp";

            }else {
                System.out.println("添加用户失败");
                return null;
            }


    }
    public String editAdminUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {

        String  user_id = req.getParameter("user_id");

        AdminUserDao adminUserDao = new AdminUserImp();

        AdminUser adminUser =  adminUserDao.selectAdminUserById(user_id);

        req.getSession().setAttribute("adminUser", adminUser);

        return "views/admin/editAuth.jsp";


    }
    public void changePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getParameter("path");
        req.getSession().setAttribute("path", path);

        System.out.println(path);

     /*   try {
            req.getRequestDispatcher(path).forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }*/
        //return "/index.jsp";
    }






}
