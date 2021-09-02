package tn.itbs.hebergement.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.hebergement.entities.Chambre;
import tn.itbs.hebergement.entities.ContactHotel;
import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.service.ChambreServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("api/v1/chambres")
public class ChambreController {
	
	@Autowired
	private ChambreServiceImpl chambreServiceImpl;
	
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> createChambre(@Valid @RequestBody Chambre chambre) {
		try {
			chambreServiceImpl.createChambre(chambre);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/")
	public Page<Chambre> getAllChambres(
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size
			
			){
		return chambreServiceImpl.getAllChambres(PageRequest.of(page, size));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Chambre> getCChambreById(@PathVariable(value = "id") Long idChambre)
			throws ResourceNotFoundException {
		Chambre chambre = chambreServiceImpl.getChambrerById(idChambre);
		return ResponseEntity.ok().body(chambre);
	}
	
	@GetMapping("/nom")
	public ResponseEntity<Page<Chambre>> getChambreByChambreNom(@RequestParam String nom ,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size)
			throws ResourceNotFoundException {
		return new ResponseEntity<Page<Chambre>>(chambreServiceImpl.getChambreByChambreNom(nom,PageRequest.of(page, size)),
				HttpStatus.OK);
	}
	@GetMapping("/etat")
	public ResponseEntity<Page<Chambre>> getChambreByEtat(@RequestParam boolean etat,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size)
			throws ResourceNotFoundException {
		return new ResponseEntity<Page<Chambre>>(
				chambreServiceImpl.getChambreByEtat(etat,PageRequest.of(page, size)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateChambre(@PathVariable(value = "id") Long idChambre,
			@Valid @RequestBody Chambre chambreDetails) throws ResourceNotFoundException {

		chambreServiceImpl.updateChambre(idChambre, chambreDetails);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteProduit(@PathVariable(value = "id") Long idChambre) {
		try {
			chambreServiceImpl.deleteById(idChambre);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
