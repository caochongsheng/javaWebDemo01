package com.hs.demo01.dao.adminImp;

import com.hs.demo01.bean.admin.AdminAuth;
import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.dao.AdminAuthDao;
import com.hs.demo01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminAuthImp implements AdminAuthDao {
    @Override
    public List<AdminAuth> selectAllAuths() throws SQLException {

        JDBCUtils.getConnection();
        String sql = "select * from ikan_admin_auth";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<AdminAuth> list = qr.query(sql, new BeanListHandler<AdminAuth>(AdminAuth.class));
        return list;
    }

    @Override
    public AdminAuth selectOneAuth(Integer id) throws SQLException {


        return null;
    }

    @Override
    public int insertAuth(AdminAuth auth) throws SQLException {
        return 0;
    }

    @Override
    public int updateAuth(AdminAuth auth) throws SQLException {
        return 0;
    }

    @Override
    public List<AdminAuth> selectAuthsByRole(AdminRole role) throws SQLException {

        JDBCUtils.getConnection();
        String sql = "select * from ikan_admin_auth  a left join ikan_admin_role_auth b on a.id = b.auth_id where b.role_id=?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<AdminAuth> list = qr.query(sql, new BeanListHandler<AdminAuth>(AdminAuth.class),role.getId());
        return list;

    }
}
