package com.hs.demo01.web.filter;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.bean.admin.AdminUser;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class PriviledgeFilter implements Filter {

    public PriviledgeFilter() {
    }


    public void destroy() {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest myReq = (HttpServletRequest) request;
        //判断当前的session中是否存在已经登录成功的用户

        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println(url);
        if(url.indexOf("login")<0){
        AdminUser user = (AdminUser) myReq.getSession().getAttribute("loginUser");
        if (null != user) {
            //如果存在,放行
            chain.doFilter(request, response);
        } else {
            //如果不存在,转入到提示页面
            myReq.setAttribute("msg", "请用户登录之后再去访问");
            //转入到提示页面
            myReq.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }


    }else {

            chain.doFilter(request, response);
        }



    }


    public void init(FilterConfig fConfig) throws ServletException {

    }

}
