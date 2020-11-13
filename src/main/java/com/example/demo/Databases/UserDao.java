package com.example.demo.Databases;

import com.example.demo.Entity.UserInfo;

import java.util.Collection;

public interface UserDao {

    Collection<UserInfo> getAllUsers();

    UserInfo getUserEmail(String email);
    UserInfo getUserName(String username);
    UserInfo getUserPassword(String password);

    void removeUserById(int id);

    void updateUser(UserInfo user);

    void insertUserToDb(UserInfo user);
}
