package tn.itbs.hebergement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.hebergement.entities.AppRole;


public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRole(String role);

}
