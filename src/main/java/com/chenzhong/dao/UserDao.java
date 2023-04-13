package com.chenzhong.dao;

import com.chenzhong.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = String.format("select * from usertable where username='%s' and password='%s'",username,password);
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
            return new User(rs.getInt("id"),rs.getString("username"),
                    rs.getString("password"),rs.getString("email"),rs.getString("gender"),
                    rs.getDate("birthdate"));
        }else return null;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthdate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByAllUser(Connection con) throws SQLException {
        return null;
    }
}
