package tn.itbs.hebergement.service;

import java.util.List;
import org.springframework.data.domain.Pageable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.Chambre;
import tn.itbs.hebergement.entities.ContactHotel;
import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.ChambreRepository;

@Service
@Transactional
@Slf4j
public class ChambreServiceImpl implements IChambreService {
	
	@Autowired
	private ChambreRepository chambreRepository;

	@Override
	public Chambre createChambre(Chambre chambre) {
		
		return chambreRepository.save(chambre);
	}

	@Override
	public Page<Chambre> getAllChambres(PageRequest pageRequest) {
		return chambreRepository.findAll(pageRequest);
	}

	@Override
	public Chambre getChambrerById(Long id) throws ResourceNotFoundException {
		
		return chambreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Chambre avec l'id = "+ id +" introuvable "));
	}

	@Override
	public Page<Chambre> getChambreByChambreNom(String chambreNom, Pageable pageable) throws ResourceNotFoundException {
		
		return chambreRepository.findChambreByTypeChambre_Nom(chambreNom, pageable);
	}

	@Override
	public Page<Chambre> getChambreByEtat(boolean etat, PageRequest pageRequest) {
		
		return chambreRepository.findByEtat(etat,pageRequest);
	}

	@Override
	public Chambre updateChambre(Long id, Chambre chambreDetails) throws ResourceNotFoundException {
		Chambre chambre = chambreRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Chambre avec l'id = "+ id +" introuvable "));
		chambre.setNumeroChambre(chambreDetails.getNumeroChambre());
		chambre.setCohabitaion(chambreDetails.isCohabitaion());
		chambre.setAccesHandicape(chambreDetails.isAccesHandicape());
		chambre.setEtageChambre(chambreDetails.getEtageChambre());
		chambre.setEtat(chambreDetails.isEtat());
		chambre.setMetrageChambre(chambreDetails.getMetrageChambre());
		chambre.setTypeChambre(chambreDetails.getTypeChambre());
		chambre.setHotel(chambreDetails.getHotel());
		return chambreRepository.save(chambre);
	}

	@Override
	public void deleteById(Long id) throws ResourceNotFoundException {
		Chambre chambre =
				chambreRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Chambre avec l'id = "+ id +" introuvable "));
		chambreRepository.delete(chambre);
		
	}

}
