package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserInfo {

    private Integer id;
    private String userName;
    private String email;
    private String password;


    public UserInfo(){}
    public UserInfo(String userName,String email,String password){
        this.userName = userName;
        this.email = email;
        this.password=password;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    private String getUserName(){
        return this.userName;
    }
    private String getEmail(){
        return this.email;
    }
    private String getPassword(){
        return this.password;
    }



}
