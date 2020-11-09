package com.example.demo.Databases;


import com.example.demo.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("godrink")
public class UserInfoDao implements  UserDao{


    //@Override
    public Collection<UserInfo> getAllStudents() {
        return null;
    }

    @Override
    public Collection<UserInfo> getAllUsers() {
        return null;
    }

    @Override
    public UserInfo getUserbyId(int id) {
        return null;
    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public void updateUser(UserInfo user) {

    }

    @Override
    public void insertUserToDb(UserInfo user) {

    }
}
