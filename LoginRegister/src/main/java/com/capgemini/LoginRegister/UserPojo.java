package com.capgemini.LoginRegister;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Document(collection="UserList")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class UserPojo
{
	
	String userName;
	 
	String userMail;
	
	String phone;
	
	String password;
	 

	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPojo(String userName, String userMail, String phone, String password) {
		super();
		
		this.userName = userName;
		this.userMail = userMail;
		this.phone = phone;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserPojo [userName=" + userName + ", userMail=" + userMail + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
}
