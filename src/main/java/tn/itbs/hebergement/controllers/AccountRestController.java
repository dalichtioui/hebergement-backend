package tn.itbs.hebergement.controllers;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.dto.RegisterForm;
import tn.itbs.hebergement.entities.AppUser;
import tn.itbs.hebergement.service.AccountService;


@Slf4j
@RestController
@RequestMapping("api/v1")
public class AccountRestController {
	@Autowired
	//private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userFrom) {
		if(!userFrom.getPassword().equals(userFrom.getConfirmPassword()))
				throw new RuntimeException("you must confirm your password");
		AppUser user = accountService.findUserByUsername(userFrom.getUsername());
		if(user!=null) throw new RuntimeException("user already exist");
		AppUser appUser = new AppUser();
		appUser.setUsername(userFrom.getUsername());
		appUser.setPassword(userFrom.getPassword());
		log.info("user registred");
		return accountService.saveUser(appUser);
	}
}*/
