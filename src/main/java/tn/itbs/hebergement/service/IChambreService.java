package tn.itbs.hebergement.service;

import java.util.List;
import org.springframework.data.domain.Pageable;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import tn.itbs.hebergement.entities.Chambre;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;

public interface IChambreService  {
	
	Chambre createChambre(Chambre chambre);
	
	Page<Chambre> getAllChambres(PageRequest pageRequest);
	
	Chambre getChambrerById(Long id) throws ResourceNotFoundException;
	
	Page<Chambre> getChambreByChambreNom(String chambreNom, Pageable pageable) throws ResourceNotFoundException;
	
	Page<Chambre> getChambreByEtat (boolean etat,PageRequest pageRequest);
		
	Chambre updateChambre(Long id, Chambre chambreDetails) throws ResourceNotFoundException;
	
	void deleteById(Long id) throws ResourceNotFoundException;
}
