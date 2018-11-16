package com.hs.demo01.web.servlet;

import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.dao.adminImp.AdminUserImp;
import com.hs.demo01.dao.services.LoginService;
import com.hs.demo01.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends BaseServlet {


    // 登录接口
    public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        LoginService loginService = new LoginService();
        AdminUser resultUser =  loginService.login(req.getParameter("name"),req.getParameter("pwd"));

        System.out.println("登录成功"+resultUser);

        if(resultUser != null ){
            req.getSession().setAttribute("loginUser",resultUser);

            List<AdminUser> adminUsers = null;

            AdminUserDao adminUserDao = new AdminUserImp();
            try {
                adminUsers = adminUserDao.selectAllUser();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            req.getSession().setAttribute("path", "views/admin/authList.jsp");
            req.getSession().setAttribute("adminUsers", adminUsers);

            resp.sendRedirect("/index.jsp");

            return null;

        }else {
            req.setAttribute("msg", "用户名或者密码错误，请重新登录");
            return "views/login.jsp";
        }


    }



    // 默认方法
    public String loginOut(HttpServletRequest req, HttpServletResponse response) throws Exception {

        req.getSession().removeAttribute("loginUser");
        PrintWriter out = response.getWriter();
        out.println("<script language='javascript'> window.location.replace('/views/login.jsp'); </script>");

        return null;
    }




}
