package com.controller;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
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
public class UserController {
	ApplicationContext context;
	
	@RequestMapping(value = "/openAddUser", method = RequestMethod.GET)
	public String openUpdate(
		   ModelMap model) {
		 User user = new User();
		 model.addAttribute("user", user);
		 return "addUser";
	}
	
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	//public ModelAndView addUser(@WebParam("username") String username , @WebParam("password") String password) {
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("home");
			context = new ClassPathXmlApplicationContext("beans.xml");
			UserDAO userDao = (UserDAO) context.getBean("UserDAO");
			userDao.addUser(user);
			List<User> usersList = userDao.getUsers();
			view.addObject("userList", usersList);
			view.addObject("message", "User Added");
			 
		}catch(Exception e) {
			view = new ModelAndView("addUser");
			view.addObject("message", e.getMessage());
			e.printStackTrace();
		}
		return view;
	}
	

	 @RequestMapping(value = "/openUpdate", method = RequestMethod.GET)
	public String openUpdate(
			@RequestParam("user_id") String user_id,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("role") String role,
		   ModelMap model) {
		 System.out.println("openUpdate");
		 User user = new User();
		 user.setUser_id(Integer.valueOf(user_id));
		 user.setUsername(username);
		 user.setPassword(password);
		 user.setRole(role);
		 
		 model.addAttribute("user", user);
		 return "updateUser";
	}
	 
	 @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	 public ModelAndView updateUser(@ModelAttribute("user") User user ,  BindingResult result,  ModelMap model) {
		 
		 ModelAndView view = null;
		  try {
				  view = new ModelAndView("home");
				  int user_id = user.getUser_id();
				  System.out.println(user_id);
				  if(user_id == 1) {
					  throw new Exception("Test Error");
				  }
		 
				  
			  	context = new ClassPathXmlApplicationContext("beans.xml");
			    UserDAO userJDBCTemplate = (UserDAO) context.getBean("UserDAO");
			    
			    userJDBCTemplate.updateUser(user);
			    
			    List<User> list = userJDBCTemplate.getUsers();
			    view.addObject("userList", list);
			    view.addObject("message", "User Updated");
			   
		  }catch(Exception e) {
			  e.printStackTrace();
			  view = new ModelAndView("updateUser");
			  view.addObject("message", e.getMessage());
			  
		  }
		  return view;
	 }
	 
	 @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	 public ModelAndView deleteUser(@RequestParam("user_id") String userId ) {
		 
		 ModelAndView view = null;
		  try {
			  
				view = new ModelAndView("home");
			  	context = new ClassPathXmlApplicationContext("beans.xml");
			    UserDAO userJDBCTemplate = (UserDAO) context.getBean("UserDAO");
			    System.out.println("will delete user : "+userId);
			    userJDBCTemplate.deleteUser(userId);
			    
			    List<User> list = userJDBCTemplate.getUsers();
			    view.addObject("userList", list);
			    view.addObject("message", "User Deleted"); 
			    view.addObject("user", new User());
			    
			   
		  }catch(Exception e) {
			  e.printStackTrace();
			  view.addObject("message", e.getMessage());
			  
		  }
		  return view;
	 }
}
