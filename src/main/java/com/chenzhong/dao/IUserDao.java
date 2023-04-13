package com.chenzhong.dao;

import com.chenzhong.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    boolean saveUser(Connection con, User user) throws SQLException;
    int deleteUser(Connection con,User user) throws SQLException;
    int updateUser(Connection con, User user) throws SQLException;
    User findById(Connection con,Integer id) throws SQLException;
    User findByUsernamePassword(Connection con,String username,String password) throws SQLException;
    List<User> findByUsername(Connection con, String username) throws  SQLException;
    List<User> findByPassword(Connection con, String password) throws  SQLException;
    List<User> findByEmail(Connection con, String email) throws  SQLException;
    List<User> findByGender(Connection con, String gender) throws  SQLException;
    List<User> findByBirthdate(Connection con, String birthdate) throws  SQLException;
    List<User> findByAllUser(Connection con) throws  SQLException;

}
