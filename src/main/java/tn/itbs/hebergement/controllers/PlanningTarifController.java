package tn.itbs.hebergement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.PlanningTarif;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.service.PlanningTarifServiceImpl;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class PlanningTarifController {
	@Autowired
	private PlanningTarifServiceImpl planningTarifServiceImpl;
	
	@GetMapping("/planningTarif/{id}")
	public ResponseEntity<PlanningTarif> getHotelById(@PathVariable(value = "id") Long idPlanning)
			throws ResourceNotFoundException {
		PlanningTarif planningTarif = planningTarifServiceImpl.getPlanningById(idPlanning);
		return ResponseEntity.ok().body(planningTarif);
	}
	
	@PostMapping("/planningTarif")	
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> createPlanningTarif(@Valid @RequestBody PlanningTarif planning) {
		try {
			planningTarifServiceImpl.createPlanning(planning);
			log.info("ajout planning");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Page<PlanningTarif>> getPlanningByTypeChambre (
			@RequestParam String typeChambre,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size)throws ResourceNotFoundException {
		return new ResponseEntity<Page<PlanningTarif>>(planningTarifServiceImpl.getPlanningByTypeChambre(typeChambre,PageRequest.of(page, size)), HttpStatus.OK);
		
		
		
	}

	
}
