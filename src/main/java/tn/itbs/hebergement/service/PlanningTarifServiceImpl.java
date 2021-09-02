package tn.itbs.hebergement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import tn.itbs.hebergement.entities.PlanningTarif;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.PlanningTarifRepository;

public class PlanningTarifServiceImpl implements PlanningTarifService{
	@Autowired
	private PlanningTarifRepository planningTarifRepository;
	
	@Override
	public PlanningTarif createPlanning(PlanningTarif planning) {
		
		return planningTarifRepository.save(planning);
	}

	@Override
	public PlanningTarif updatePlanning(Long id, PlanningTarif planningDetails) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanningTarif getPlanningById(Long id) throws ResourceNotFoundException {
		
		return planningTarifRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planning avec l'id = "+ id +" introuvable "));
	}

	@Override
	public PlanningTarif getPlanningByHotelNom(String nomHotel) throws ResourceNotFoundException {
		return planningTarifRepository.findPlanningTarifByHotel_Nom(nomHotel);//a revoir pas tres convaincu avec l'idee
	}

	@Override
	public Page<PlanningTarif> getPlanningByTypeChambre(String typeChambre, Pageable pageable)
			throws ResourceNotFoundException {
		
		return planningTarifRepository.findPlanningTarifByTypeChambre_Nom(typeChambre, pageable);
	}


}
