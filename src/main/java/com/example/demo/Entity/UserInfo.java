package com.example.demo.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserInfo {




    private String userName;
    private String email;
    private String password;

    public UserInfo(){}

    public UserInfo(String userName,String email,String password){
        super();

        this.userName = userName;
        this.email = email;
        this.password=password;
    }


    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }


}
