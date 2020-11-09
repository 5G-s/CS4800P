package com.example.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class UserInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String email;
    private String password;

    public UserInfo(){}
    public UserInfo(Long id){this.setId(id);}

    public UserInfo(Long id,String userName,String email,String password){
        super();
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password=password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
