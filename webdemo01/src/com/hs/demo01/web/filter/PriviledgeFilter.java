package com.hs.demo01.web.filter;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.bean.admin.AdminUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PriviledgeFilter implements Filter {

    //实例化一个静态的集合
    private static List<String> urls = new ArrayList<String>();
    //静态代码块中向集合中存放所有可以放行的请求或网页地址（不用账号密码即可访问）
    static {
        urls.add("/public"); // 静态资源 不过滤 css js  img  等
        urls.add("login.jsp");
        urls.add("/login");
    }


    public PriviledgeFilter() {
    }


    public void destroy() {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
         //得到当前页面所在目录下全名称
        String urlPattern=req.getServletPath();
       //得到页面所在服务器的绝对路径
        String path = req.getRequestURI();
        //System.out.println(urlPattern);
        for (String url : urls) {
            if(url.equals(urlPattern) || path.contains(url)) {
                //        System.out.println("reaource do chain...");
                chain.doFilter(request, response);
                //防止重复响应
                return;
            }
        }
        AdminUser user = (AdminUser) req.getSession().getAttribute("loginUser");

        if(user == null){
            PrintWriter out = response.getWriter();

            out.println("<script language='javascript'> window.location.replace('/views/login.jsp'); </script>");

        }else {
            chain.doFilter(request, response);
        }


    }


    public void init(FilterConfig fConfig) throws ServletException {

    }

}
