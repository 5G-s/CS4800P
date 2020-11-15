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


@RestController
@WebServlet("/LoginServlet")
public class Login extends HttpServlet {

    @Autowired
    private UserServices userServices;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        //User Variables
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // code to process the form...
        UserInfo userByEmail = userServices.getUserEmail(email);
        UserInfo userByName = userServices.getUserName(username);

        //check email first then username
        if( userByEmail.getEmail().equals(email) ){
            //found account by email check password
            if(userByEmail.getPassword().equals(password)){
                //login verified redirect to another html
                response.sendRedirect("main.html");
            }
        }
        else if (userByName.getUserName().equals(username)) {
            //Found account by username check password
            if(userByEmail.getPassword().equals(password)){
                //login verified redirect to another html
                response.sendRedirect("main.html");
            }
        }
        //if email or username dont match refresh page
        response.sendRedirect("Login.html");




    }

}
