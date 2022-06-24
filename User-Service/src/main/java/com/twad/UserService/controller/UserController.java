package com.twad.UserService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twad.UserService.dao.UserDetailsDAO;
import com.twad.UserService.dto.UserDetails;
import com.twad.UserService.model.User;
//import com.twad.UserService.model.User;
import com.twad.UserService.service.UserInfoImpl;
import com.twad.UserService.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	
	  @PostMapping("/create-user") 
	  public String saveUser(@RequestBody User user) {
	  Optional<User> _user = userService.create(user); 
	  if(_user.isPresent()){
		  return "The user data has been saved successfully!"; }
	  else{ 
		  return "User already exist in records"; 
		  } 
	  }
	  
	  @GetMapping("/getUserById/{id}") 
	  public ResponseEntity<User> getUserById(@PathVariable("id") int id) { 
		  Optional<User> user =userService.retrieveOne(id); 
		  if (user.isPresent()) { 
			  return new ResponseEntity<>(user.get(), HttpStatus.OK); } 
		  else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  } 
	  }
	  
	  @GetMapping("/getALLUsers/{offset}/{pagesize}") 
	  public List<User> getALLUsers(@PathVariable int offset, @PathVariable int pagesize) { 
		  return userService.retrieve(offset,pagesize); }
	  
	  @PutMapping("/updateUser") 
	  public String updateUser(@RequestBody User user) {
	  Optional<User> _user = userService.update(user); 
	  if(_user.isEmpty()){ 
		  return "The user data does not exist in records!"; 
	  }
	  else{ 
		  return "The user data has been updated successfully!"; 
		  } 
	  }
	  
	  @DeleteMapping("/delete/{id}") 
	  public String deleteUserById(@PathVariable("id") int id) { 
		  return userService.delete(id); 
	  }
	    
	  @GetMapping("/getAllUserDetails")
	  public List<UserDetailsDAO> getAllUserDetails() {
	      return userService.getAllUserDetails();
	    }

	    
	    
}
