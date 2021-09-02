package tn.itbs.hebergement.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.itbs.hebergement.entities.AppRole;
import tn.itbs.hebergement.entities.AppUser;
import tn.itbs.hebergement.repository.AppRoleRepository;
import tn.itbs.hebergement.repository.AppUserRepository;



/*@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Override
	public AppUser saveUser(AppUser user) {
		String HashPW=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(HashPW);
		return appUserRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = appRoleRepository.findByRole(roleName);
		AppUser user = appUserRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}
	
	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUsername(username);
	}

	

}*/