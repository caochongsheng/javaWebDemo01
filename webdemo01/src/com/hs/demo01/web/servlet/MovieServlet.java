package com.hs.demo01.web.servlet;

import com.hs.demo01.dao.UsersDao;
import com.hs.demo01.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by shengcaochong on 2018/10/20.
 */
public class MovieServlet extends BaseServlet {



    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws IOException {



        Map<String, String[]> map =   req.getParameterMap();


        UsersDao user = new UsersDao();
        user.setId("我是一个ID");

        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user.getName());

        System.out.println(user.toString());




        return "/index.jsp";
    }





}
