package tn.itbs.hebergement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.itbs.hebergement.entities.TypeChambre;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;

public interface TypeChambreService {
	
	TypeChambre getTypeChambreById(Long id) throws ResourceNotFoundException;
	
	Page<TypeChambre> getAllTypeChambres(Pageable pageable);
	
	TypeChambre createTypeChambre(TypeChambre typeChambre);
	
	TypeChambre updateTypeChambre(Long id, TypeChambre typeChambreDetails)throws ResourceNotFoundException;
	
	void deleteById(Long id) throws ResourceNotFoundException;

}
