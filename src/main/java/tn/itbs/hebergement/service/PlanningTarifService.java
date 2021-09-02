package tn.itbs.hebergement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.itbs.hebergement.entities.PlanningTarif;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;

public interface PlanningTarifService {
 PlanningTarif createPlanning(PlanningTarif planning);
 PlanningTarif updatePlanning(Long id, PlanningTarif planningDetails) throws ResourceNotFoundException;
 PlanningTarif getPlanningById(Long id) throws ResourceNotFoundException;
 PlanningTarif getPlanningByHotelNom(String nomHotel) throws ResourceNotFoundException;
 Page<PlanningTarif> getPlanningByTypeChambre(String typeChambre, Pageable pageable) throws ResourceNotFoundException;


}
