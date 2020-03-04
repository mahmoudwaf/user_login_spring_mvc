package com.controller;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beans.User;
import com.dao.UserDAO;

@Controller

public class LoginController {
	
	 private ApplicationContext context;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String initView(Model model) {
		 System.out.println("init. view");
	        model.addAttribute("user", new User());
	        return "login";
	    }
	 
	/* @RequestMapping(value = "/home", method = RequestMethod.GET)
	    public String home(Model model) {
		 	
	        return "home";
	    }
	 */
	 
	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	    public ModelAndView login(@ModelAttribute("user") User user ,  BindingResult result,  ModelMap model) {
		    System.out.println("login");
		    context = new ClassPathXmlApplicationContext("beans.xml");
		    UserDAO userJDBCTemplate = (UserDAO) context.getBean("UserDAO");
		    List<User> list = userJDBCTemplate.getUsers();
		    
		   
	       // model.addAttribute("user", user); 
	        model.addAttribute("username", user.getUsername());
	        model.addAttribute("password", user.getPassword());
	        
	        ModelAndView loginView = new ModelAndView("login");
	        ModelAndView homeView = new ModelAndView("home");
	        
	        if("mahmoud".equals(user.getUsername()) && "nour".equals(user.getPassword())) {
	        	System.out.println("User logged in");
	        	homeView.addObject("userList", list);
	        	homeView.addObject("user", new User());
	        	homeView.addObject("message", "Welcome Ya "+user.getUsername());
	        	return homeView;
	        }else {
	        	loginView.addObject("message", "Invalid login");
	        	return loginView;
	        }
	        
	    }
	 
	 
	 @RequestMapping(value = "/home", method = RequestMethod.GET)
	    public ModelAndView home(@ModelAttribute("user") User user ,  BindingResult result,  ModelMap model) {
		    System.out.println("home");
		    context = new ClassPathXmlApplicationContext("beans.xml");
		    UserDAO userJDBCTemplate = (UserDAO) context.getBean("UserDAO");
		    List<User> list = userJDBCTemplate.getUsers();
		    
	        ModelAndView homeView = new ModelAndView("home");
	        homeView.addObject("userList", list);
	        return homeView;	 
	        
	    }
	 

}
