package com.hs.demo01.dao;

import com.hs.demo01.bean.Movie;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by shengcaochong on 2018/10/21.
 */
public interface MovieDao {

//    void userRegist(Movie user)throws SQLException;
//
//    Movie userActive(String code)throws SQLException;
//
//    void updateUser(Movie user)throws SQLException;
//
//    Movie userLogin(Movie user)throws SQLException;

    // 用户注册
    List<Movie> findMovie() throws SQLException;


}
