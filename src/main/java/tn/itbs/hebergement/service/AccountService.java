package tn.itbs.hebergement.service;

import tn.itbs.hebergement.entities.AppRole;
import tn.itbs.hebergement.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String role);
	public AppUser findUserByUsername(String username);

}