package tn.itbs.hebergement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.hebergement.entities.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);

}
