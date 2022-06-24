
  package com.twad.UserService.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.stereotype.Repository;
  
  import com.twad.UserService.model.User;
  
  @Repository 
  public interface UserRepository extends JpaRepository<User,Integer>{
  
  }
 