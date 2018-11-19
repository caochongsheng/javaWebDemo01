package com.hs.demo01.web.servlet;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.dao.services.AuthService;
import com.hs.demo01.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AuthServlet extends BaseServlet {

    // 默认方法
    public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception {

         AuthService authService = new AuthService();
         List<AdminAuth> auths = authService.getAllAuths();
         System.out.println(auths.toString());
        req.getSession().setAttribute("auths", auths);

        return "views/admin/authList.jsp";
    }
    public String edit(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        AuthService authService = new AuthService();
        List<AdminAuth> auths = authService.getAllAuths();
        req.getSession().setAttribute("auths", auths);

        return null;
    }

    public String del(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        AuthService authService = new AuthService();
        List<AdminAuth> auths = authService.getAllAuths();
        req.getSession().setAttribute("auths", auths);

        return null;
    }

    public String add(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        AuthService authService = new AuthService();
        List<AdminAuth> auths = authService.getAllAuths();
        req.getSession().setAttribute("auths", auths);

        return null;
    }


}
