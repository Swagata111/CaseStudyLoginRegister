package com.capgemini.LoginRegister;


import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

	public class LoginRegisterController 
	{
		@Autowired
		private UserService userRepo;	
		@Autowired
		public JavaMailSender emailSender;
		
	/*
	 * @RequestMapping(value = "/mail", method = RequestMethod.GET) public String
	 * sendSimpleMessage() throws Exception { return AmazonSESSample.sendEmail();
	 * 
	 * }
	 * 
	 */
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		   public boolean login(Model model,@RequestBody UserPojo user,BindingResult result,Map<String,Object> model1)				   
		   {
	    	
	    	UserPojo checkUser=new UserPojo();
	    	checkUser=userRepo.findByuserName(user.userName);
	   	if(checkUser.getPassword().equals(user.password))
    		return true;
    	return false;
	    		    	
	       } 
		
		@RequestMapping(value="/login1", method=RequestMethod.POST)
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserPojo user) {

		    // check the submitted username and password
			System.out.println("Reached Login Controller");
			UserPojo checkUser=new UserPojo();
	    	checkUser=userRepo.findByuserName(user.userName);
	    	if(checkUser.getPassword().equals(user.password))
	    	{
	    		System.out.println("Reached");
		        return new ResponseEntity<>(null, HttpStatus.OK);
		    } else {
		    	System.out.println("NOT Reached");
		        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		    }
		}
		
	    @RequestMapping(value = "/email/{userMail}", method = RequestMethod.GET)
	    public UserPojo getEmailId(@PathVariable String userMail)
	    {
	    	return userRepo.findByuserMail(userMail);
	    }
	    
	    
	    @RequestMapping(value = "/phone/{phone}", method = RequestMethod.GET)
	    public UserPojo getPhone(@PathVariable String phone)
	    {
	    	return userRepo.findByPhone(phone);
	    }
	    
	    
	    
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
		   public void regvalid(Model model,@RequestBody UserPojo user,BindingResult result,Map<String,Object> model1) throws Exception				   
		   {

	        if (result.hasErrors()) {
	            throw new ValidationException();
	        }
	    		userRepo.create(user.userName,user.userMail,user.phone,user.password);	
	    		AmazonSESSample.sendEmail(user.userMail,user.userName);
	       }
	}