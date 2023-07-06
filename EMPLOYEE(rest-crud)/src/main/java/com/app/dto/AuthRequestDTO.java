package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthRequestDTO {
	@NotBlank(message="email cannt be blank")
	@Email(message="invalid email format")
	private String email;
	@NotBlank(message="password is required")
	private String password;
}
