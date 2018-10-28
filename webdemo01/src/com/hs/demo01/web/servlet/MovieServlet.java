package com.hs.demo01.web.servlet;

import com.hs.demo01.admin.User;
import com.hs.demo01.dao.UserDao;
import com.hs.demo01.dao.daoimp.UserDaoImp;
import com.hs.demo01.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by shengcaochong on 2018/10/20.
 */
public class MovieServlet extends BaseServlet {



    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        Map<String, String[]> map =   req.getParameterMap();


        User user = new User();




        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println(user.toString());


        UserDao userDao = new UserDaoImp();
        try {
            userDao.userRegist(user);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("9999999");
            System.out.println(e.getMessage());
        }


        return "/index.jsp";
    }





}
