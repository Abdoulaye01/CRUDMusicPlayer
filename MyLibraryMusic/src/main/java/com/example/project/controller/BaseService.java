package com.example.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.project.model.User;



@Component
public class BaseService {
	
   public User getCurrentUserInfo( HttpSession session){
	   User user = (User)session.getAttribute("user");
	   if(user !=null){
			  System.out.println("From Base Service Email from Session: " + user.getUsername());
			  System.out.println("From Base Service Name Session: " + user.getPassword());
	   }
	  return user;
   }


}