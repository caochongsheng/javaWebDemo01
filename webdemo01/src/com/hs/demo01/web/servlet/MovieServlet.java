package com.hs.demo01.web.servlet;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.dao.MovieDao;
import com.hs.demo01.dao.daoimp.MovieDaoImp;
import com.hs.demo01.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by shengcaochong on 2018/10/20.
 */
public class MovieServlet extends BaseServlet {

    public String index(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> map =   req.getParameterMap();

        Movie user = new Movie();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());

        List<Movie> movies = null;

        MovieDao userDao = new MovieDaoImp();
        try {
            movies = userDao.findMovie();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (movies != null) {
            System.out.println(movies);
        }

        req.getSession().setAttribute("path", "views/admin/authList.jsp");
        req.getSession().setAttribute("movies", movies);

        return "/index.jsp";
    }


    public String changePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getParameter("path");
        req.getSession().setAttribute("path", "views/admin/addAuth.jsp");
        return "/index.jsp";
    }


}
