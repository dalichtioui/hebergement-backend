package tn.itbs.hebergement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.entities.TypeChambre;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.TypeChambreRepository;

@Service
@Slf4j
@Transactional
public class TypeChambreServiceImpl implements TypeChambreService {
	
	@Autowired
	private TypeChambreRepository typeChambreRepository;

	@Override
	public Page<TypeChambre> getAllTypeChambres(Pageable pageable) {
		
		return typeChambreRepository.findAll(pageable);
	}

	@Override
	public TypeChambre createTypeChambre(TypeChambre typeChambre) {
		
		return typeChambreRepository.save(typeChambre);
	}

	@Override
	public TypeChambre updateTypeChambre(Long id, TypeChambre typeChambreDetails) throws ResourceNotFoundException {
		TypeChambre typeChambre = typeChambreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type Chambre avec l'id = "+ id +" introuvable "));
		typeChambre.setNom(typeChambreDetails.getNom());
		typeChambre.setNombreOccupant(typeChambreDetails.getNombreOccupant());
		typeChambre.setEtat(typeChambreDetails.isEtat());
		return null;
	}

	@Override
	public void deleteById(Long id) throws ResourceNotFoundException {
		TypeChambre typeChambre =
				typeChambreRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Type Chambre avec l'id = "+ id +" introuvable "));
		typeChambreRepository.delete(typeChambre);
		
	}

	@Override
	public TypeChambre getTypeChambreById(Long id) throws ResourceNotFoundException {
		
		 return typeChambreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type Chambre avec l'id = "+ id +" introuvable "));
	}

}
