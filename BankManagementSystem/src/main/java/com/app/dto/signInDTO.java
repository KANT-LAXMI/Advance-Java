package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class signInDTO {
	
	@Email
	private String email;
	@NotBlank(message = "password is required")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
