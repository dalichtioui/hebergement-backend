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

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.TypeChambre;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.service.TypeChambreServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/v1/typeChambres")
public class TypeChambreController {
	
	@Autowired
	private TypeChambreServiceImpl typeChambreServiceImpl;
	
	@GetMapping("/")
	public Page<TypeChambre> getAllTypeChambres(@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size){
		return typeChambreServiceImpl.getAllTypeChambres(PageRequest.of(page, size));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TypeChambre> getTypeById(@PathVariable(value = "id") Long idTypeChambre)
			throws ResourceNotFoundException {
		TypeChambre typeChambre = typeChambreServiceImpl.getTypeChambreById(idTypeChambre);
		return ResponseEntity.ok().body(typeChambre);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> createTypeChambre(@Valid @RequestBody TypeChambre typeChambre) {
		log.info("ajout type chambre");
		try {
			typeChambreServiceImpl.createTypeChambre(typeChambre);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateTypeChambre(@PathVariable(value = "id") Long idTypeChambre,
			@Valid @RequestBody TypeChambre typeChambreDetails) throws ResourceNotFoundException {

		typeChambreServiceImpl.updateTypeChambre(idTypeChambre, typeChambreDetails);
		log.info("update type chambre avec id="+idTypeChambre);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTypeChambre(@PathVariable(value = "id") Long idTypeChambre) {
		log.info("suppression type chambre avec id="+idTypeChambre);
		try {
			typeChambreServiceImpl.deleteById(idTypeChambre);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
