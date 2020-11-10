package com.example.demo.Databases;


import com.example.demo.Entity.UserInfo;
import com.example.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository("godrink")
//@Qualifier("godrink")
public class UserInfoDao implements UserDao{

    @Autowired
    JdbcTemplate jdbc;

    private static class UserRowMapper implements RowMapper<UserInfo>{
        @Override
        public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
            UserInfo user = new UserInfo();
            user.setUserName(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }

    }

    @Override
    public Collection<UserInfo> getAllUsers() {
        return null;
    }

    @Override
    public UserInfo getUser(String email) {
       final String sql = "SELECT username,email,password FROM UserInfo WHERE email =?";
       UserInfo user = jdbc.queryForObject(sql, new UserRowMapper(),email);
       return user;
    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public void updateUser(UserInfo user) {

    }

    @Override
    public void insertUserToDb(UserInfo user) {
        final String sql = "INSERT INTO user (username, email, password) VALUES(?,?,?)";
        final String username = user.getUserName();
        final String email = user.getEmail();
        final String password = user.getPassword();
        jdbc.update(sql, new Object[] {username,email,password});
    }
}
