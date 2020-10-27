package com.example.demo.Controller;
//
//import com.example.demo.Model.UserInfo;
//import com.example.demo.Model.UserInfoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//public class SignUp {
//
//    @Autowired // This means to get the bean called userRepository
//    UserInfoRepository userRepo;//Create user
//
//    //adding a new user
//    @PostMapping(path="/addUser")
//    public UserInfo creatUser(@RequestBody UserInfo user) {
//        return userRepo.save(user);
//    }
//
//
//}
