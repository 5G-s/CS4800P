package com.example.demo.Databases;

import com.example.demo.Entity.UserInfo;

import java.util.Collection;

public interface UserDao {

    Collection<UserInfo> getAllUsers();

    UserInfo getUserbyId(int id);

    void removeUserById(int id);

    void updateUser(UserInfo user);

    void insertUserToDb(UserInfo user);
}
