package com.twad.UserService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twad.UserService.dao.UserDetailsDAO;
import com.twad.UserService.dto.UserDetails;
import com.twad.UserService.model.User;
import com.twad.UserService.repository.UserRepository;


@Service
public class UserService {
	
	  @Autowired 
	  private UserRepository userRepository;
	  
	  @Autowired
	  private UserInfoImpl userInfoImpl;
		
	  
	  public Optional<User> create(User user){ if
	  (userRepository.existsById(user.getId())){ return Optional.empty(); }else{
	  return Optional.of(userRepository.save(user)); } }
	  
	  public List<User> retrieve(int offset, int pagesize){ 
		  Pageable pager=PageRequest.of(offset, pagesize);
		  Page<User> PageResult= userRepository.findAll(pager);
		  return PageResult.toList(); 
	  } 
	  
	  public Optional<User> retrieveOne(int Userid){ return
	  userRepository.findById(Userid); } public Optional<User> update(User user){
	  if (userRepository.existsById(user.getId())){ return
	  Optional.of(userRepository.save(user)); }else{ return Optional.empty(); } }
	  
	  public String delete(int Userid){ if (userRepository.existsById(Userid)){
	  userRepository.deleteById(Userid); return Userid + " deleted successfully!";
	  }else{ return "The user data does not exist in records!"; }
	  
	  }
	  
	  public List<UserDetailsDAO> getAllUserDetails() {
		 
		  List<UserDetailsDAO> users = new ArrayList<UserDetailsDAO>();
		  
		  try {
		  List<UserDetails> usersList=  userInfoImpl.getAllUserDetails();
		  
		  if(!usersList.isEmpty()) {
			  usersList.stream().forEach(user -> {
				  List<String> roles = new ArrayList<String>();
				  List<String> departments = new ArrayList<String>();
				  if(!user.getRoles().isBlank()) {
					  roles =Arrays.asList(user.getRoles().substring(1, user.getRoles().length()-1).split(","));
				  }
				  if(!user.getDepartments().isBlank()) {
					  departments = Arrays.asList(user.getDepartments().substring(1, user.getDepartments().length()-1).split(","));
				  }
				  UserDetailsDAO udd = new UserDetailsDAO(user.getId(),user.getUsername(),user.getEmail(),user.getMobile1(),user.getMobile2(),roles,departments);
				 
				  users.add(udd);
			  });
		  }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return users;
	  }
	  
}
