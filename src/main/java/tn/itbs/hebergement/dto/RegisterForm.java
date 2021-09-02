package tn.itbs.hebergement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegisterForm {
	public String username;
	public String password;
	public String confirmPassword;

}

