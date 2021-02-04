package com.tejeet.tataclicq_clone.DataNModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LoginResponseDTO implements Serializable {

	@SerializedName("requeststatus")
	private int requeststatus;

	@SerializedName("message")
	private String message;

	@SerializedName("userid")
	private String userid;

	@SerializedName("username")
	private String username;

	@SerializedName("email")
	private String email;

	@SerializedName("mobile")
	private String mobile;

	public void setRequeststatus(int requeststatus){
		this.requeststatus = requeststatus;
	}

	public int getRequeststatus(){
		return requeststatus;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponseDTO{" + 
			"requeststatus = '" + requeststatus + '\'' + 
			",message = '" + message + '\'' + 
			",userid = '" + userid + '\'' + 
			",username = '" + username + '\'' + 
			",email = '" + email + '\'' + 
			",mobile = '" + mobile + '\'' + 
			"}";
		}
}