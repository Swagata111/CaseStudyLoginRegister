package com.capgemini.LoginRegister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
      private UserRepository repo;
  public UserPojo create(String userName,String userMail, String phone,String password) 
  {

      return repo.save(new UserPojo(userName,userMail,phone,password));   

}
  public List<UserPojo> findAlluser()
	{
       return repo.findAll();
     }
  	public UserPojo findByuserMail(String email)
  	{
         return repo.findByuserMail(email);
       }
   public UserPojo findByPhone(String phone) {
              return repo.findByPhone(phone);

       }
   public UserPojo findByuserName(String uname)
   {
	   return repo.findByuserName(uname);
   }
   public UserPojo findByPassword(String password)
   {
	   return repo.findByPassword(password);
   }
 
}
