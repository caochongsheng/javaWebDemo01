package com.hs.demo01.dao.daoimp;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.dao.MovieDao;
import com.hs.demo01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by shengcaochong on 2018/10/28.
 */
public class MovieDaoImp implements MovieDao {



    @Override
    public List<Movie> findMovie() throws SQLException {
        JDBCUtils.getConnection();
        String sql = "select * from ikan_movie where sort_id=1 and type_id=1";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Movie> list = qr.query(sql, new BeanListHandler<Movie>(Movie.class));

        return list;
    }
}
