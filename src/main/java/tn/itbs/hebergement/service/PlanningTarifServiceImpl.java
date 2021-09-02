package tn.itbs.hebergement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.PlanningTarif;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.PlanningTarifRepository;

@Service
@Slf4j
@Transactional
public class PlanningTarifServiceImpl implements PlanningTarifService{
	@Autowired
	private PlanningTarifRepository planningTarifRepository;
	
	@Override
	public PlanningTarif createPlanning(PlanningTarif planning) {
		
		return planningTarifRepository.save(planning);
	}

	@Override
	public PlanningTarif updatePlanning(Long id, PlanningTarif planningDetails) throws ResourceNotFoundException {
		PlanningTarif planningTarif = planningTarifRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planning avec l'id = "+ id +" introuvable "));
		planningTarif.setCommission(planningDetails.getCommission());
		planningTarif.setHotel(planningDetails.getHotel());
		planningTarif.setNbr_pax(planningDetails.getNbr_pax());
		planningTarif.setPlanning(planningDetails.getPlanning());
		planningTarif.setPrixAchat(planningDetails.getPrixVente());
		planningTarif.setPrixMode(planningDetails.getPrixMode());
		planningTarif.setPrixVente(planningDetails.getPrixVente());
		planningTarif.setSupplementPaxAchat(planningDetails.getSupplementPaxAchat());
		planningTarif.setSupplementPaxVente(planningDetails.getSupplementPaxVente());
		planningTarif.setTaxeSejour(planningDetails.getTaxeSejour());
		planningTarif.setTypeChambre(planningDetails.getTypeChambre());
		planningTarif.setSupplementPd(planningDetails.getSupplementPd());

		

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
