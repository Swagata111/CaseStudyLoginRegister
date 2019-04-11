package com.capgemini.LoginRegister;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends MongoRepository<UserPojo, String> 
{
	   public UserPojo findByuserName(String uname);
       public UserPojo findByPhone(String phone);
       public UserPojo findByuserMail(String email);
       public UserPojo findByPassword(String password);	
    
	  // public UserPojo create(String userId, String userName,String userMail, String phone,String password);
       

}