package com.hs.demo01.dao.daoimp;

import com.hs.demo01.admin.User;
import com.hs.demo01.dao.UserDao;
import com.hs.demo01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by shengcaochong on 2018/10/28.
 */
public class UserDaoImp implements UserDao {

    @Override
    public void userRegist(User user) throws SQLException {

        JDBCUtils.getConnection();
        String sql = "select * from ikan_movie where sort_id=1 and type_id=1";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());


        List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));

        System.out.println("xxxxxx");
        System.out.print(list);


    }


}
