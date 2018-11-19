package com.hs.demo01.dao;

import com.hs.demo01.bean.admin.AdminRole;
import com.hs.demo01.bean.admin.AdminUser;

import java.sql.SQLException;
import java.util.List;

public interface AdminUserDao {

    /**
     * 添加一条后台用户
     *
     * @param user
     * @return
     * @throws SQLException
     */
    int insertUser(AdminUser user) throws SQLException;


     AdminUser selectAdminUser(AdminUser user) throws SQLException;

     AdminUser selectAdminUserById(String id ) throws SQLException;

    /**
     * 查询所有后台管理用户列表
     *
     * @return
     * @throws SQLException
     */
    List<AdminUser> selectAllUser() throws SQLException;

    /**
     * 查询用户拥有的角色列表
     *
     * @param user 用户 id
     * @return 角色列表
     */
    List<AdminRole> selectRolesByUser(AdminUser user) throws SQLException;

    /**
     * 删除管理员
     * @param userId
     * @return
     * @throws Exception
     */
    int deleteAdminUserById(int userId) throws  Exception;


    /**
     * 删除用户所有角色
     *
     * @param user 用户id
     * @return 删除成功的条数
     */
    int deleteRolesByUser(AdminUser user) throws SQLException;


    /**
     * 为用户赋予角色
     *
     * @param user 用户 id
     * @param role 授予的角色 id
     * @return 插入成功的条数
     */
    int insertUserRole(AdminUser user, AdminRole role);

    /**
     * 根据用户名密码查询账号是否存在
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询到的账号
     */
    AdminUser selectUserByNameAndPassword(String username, String password);




}
