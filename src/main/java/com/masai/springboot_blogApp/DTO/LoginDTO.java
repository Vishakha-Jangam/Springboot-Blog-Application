package com.masai.springboot_blogApp.DTO;


public class LoginDTO {
	private String userNameOrEmail;
	private String password;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String userNameOrEmail, String password) {
		super();
		this.userNameOrEmail = userNameOrEmail;
		this.password = password;
	}
	public String getUserNameOrEmail() {
		return userNameOrEmail;
	}
	public void setUserNameOrEmail(String userNameOrEmail) {
		this.userNameOrEmail = userNameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [userNameOrEmail=" + userNameOrEmail + ", password=" + password + "]";
	}

}
