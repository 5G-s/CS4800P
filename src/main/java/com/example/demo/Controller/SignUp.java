package com.example.demo.Controller;

import com.example.demo.Entity.UserInfo;
import com.example.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;


@RestController
@WebServlet("/SignUpServlet")
public class SignUp extends HttpServlet {

    @Autowired
    private UserServices userServices;

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        //User Variables
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserInfo user = new UserInfo(username,email,password);
        // code to process the form...

        //Check for no duplicate usernames or emails before adding
        if(userServices.getUserName(username).toString().equals(user.getUserName())){
            //Implement request to use different username here//jsut refresh page for now
            return;
        }
        else if(userServices.getUserEmail(email).toString().equals(user.getEmail())){
            //Account already created with that email, redirect to login page
            response.sendRedirect("Login.html");
        }
        //insert user info to database
        userServices.insertUser(user);
    }


}
