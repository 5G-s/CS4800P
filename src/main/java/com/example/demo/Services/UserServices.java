package com.example.demo.Services;


import com.example.demo.Databases.UserDao;
import com.example.demo.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServices {

    @Autowired
    @Qualifier("godrink")
    private UserDao userDao;

    public Collection<UserInfo> getAllUsers(){
        return this.userDao.getAllUsers();
    }

    public UserInfo getUser(String email){
        return this.userDao.getUser(email);
    }


    public void removeUserById(int id) {
        this.userDao.removeUserById(id);
    }

    public void updateUser(UserInfo userInfo){
        this.userDao.updateUser(userInfo);
    }

    public void insertUser(UserInfo userInfo) {
        this.userDao.insertUserToDb(userInfo);
    }
}
