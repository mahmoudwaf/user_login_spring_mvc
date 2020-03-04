package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.User;

public class UserDAO {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	  
	 public void setDataSource(DataSource dataSource) {
		 this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   }
	 
	  public List<User> getUsers() {
		  System.out.println("UsersDao");
	      String SQL = "select * from users";
	      List <User> users = jdbcTemplate.query(SQL, new UserMapper());
	      System.out.println("users = "+users);
	      return users;
	   }
	  
	  public void updateUser(User user) {
		  String sql = "UPDATE users SET username = ? , password = ? , role = ? where user_id = ? ";
		  jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRole(),user.getUser_id());
		  System.out.println("User updated  with ID = " + user.getUser_id() );
	  }
	  
	  public void addUser(User user) {
		  String sql = "INSERT INTO users (username,password,role) VALUES(?,?,?)";
		  jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRole());
	  }
	  
	  public void deleteUser(String userId) {
		  String sql = "DELETE FROM users WHERE user_id = ? ";
		  jdbcTemplate.update(sql, userId);
		  System.out.println("User deleted  with ID = " + userId );
	  }
	  
	  public void init() {
		  System.out.println("UserDao bean initialized...");
	  }
	 
	  public void destroy() {
		  System.out.println("UserDao bean destroyed...");
	  }
}
