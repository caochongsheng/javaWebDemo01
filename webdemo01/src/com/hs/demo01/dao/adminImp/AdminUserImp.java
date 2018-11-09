package com.hs.demo01.dao.adminImp;

import com.hs.demo01.bean.Movie;
import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.bean.admin.AdminUser;
import com.hs.demo01.dao.AdminUserDao;
import com.hs.demo01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminUserImp implements AdminUserDao {

    @Override
    public int insertUser(AdminUser user) throws SQLException {

            JDBCUtils.getConnection();
            String sql = "insert into ikan_admin_user(name,pwd,role_id)values(?,?,?)";
                QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
                Object[] params={user.getName(),user.getPwd(),0};
        return  qr.update(sql,params);
    }

    @Override
    public AdminUser selectAdminUser(AdminUser user) throws SQLException {

        JDBCUtils.getConnection();
        String sql = "select * from ikan_admin_user where name=? and pwd=?";
        Object[] params={user.getName(),user.getPwd()};
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        AdminUser adminUser  = qr.query(sql, new BeanHandler<AdminUser>(AdminUser.class),params);

        return adminUser;
    }

    @Override
    public AdminUser selectAdminUserById(String id) throws SQLException {

        JDBCUtils.getConnection();
        String sql = "select * from ikan_admin_user where id=?";
        Object[] params={id};
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        AdminUser adminUser  = qr.query(sql, new BeanHandler<AdminUser>(AdminUser.class),params);

        return adminUser;

    }


    @Override
    public List<AdminUser> selectAllUser() throws SQLException {
        JDBCUtils.getConnection();
        String sql = "select * from ikan_admin_user";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<AdminUser> list = qr.query(sql, new BeanListHandler<AdminUser>(AdminUser.class));
        return list;
    }

    @Override
    public List<AdminRole> selectRolesByUser(AdminUser user) throws SQLException {
        return null;
    }

    @Override
    public int deleteRolesByUser(AdminUser user) throws SQLException {
        return 0;
    }

    @Override
    public int insertUserRole(AdminUser user, AdminRole role) {
        return 0;
    }

    @Override
    public AdminUser selectUserByNameAndPassword(String username, String password) {
        return null;
    }
}
