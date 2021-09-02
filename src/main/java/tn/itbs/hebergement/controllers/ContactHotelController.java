package tn.itbs.hebergement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.ContactHotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.service.ContactHotelImpl;
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/v1/contactHotels")
public class ContactHotelController {
	@Autowired
	private ContactHotelImpl contactHotelImpl;

	@GetMapping("/")
	public List<ContactHotel> getAllContactHotels() {
		return contactHotelImpl.getAllContactHotels();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContactHotel> getContactHotelById(@PathVariable(value = "id") Long idContact)
			throws ResourceNotFoundException {
		ContactHotel contactHotelr = contactHotelImpl.getContactHotelById(idContact);
		return ResponseEntity.ok().body(contactHotelr);
	}

	@GetMapping("/nom")
	public ResponseEntity<List<ContactHotel>> getFournisseurByNom(@RequestParam String nom)
			throws ResourceNotFoundException {
		return new ResponseEntity<List<ContactHotel>>(contactHotelImpl.getContactHotelByNom(nom),
				HttpStatus.OK);
	}


	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> createContactHotel(
			@Valid @RequestBody ContactHotel contactHotel) {
		log.info("ajout contact fournisseur");
		try {
			contactHotelImpl.createContactHotel(contactHotel);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateContactHotel(@PathVariable(value = "id") Long idContact,
			@Valid @RequestBody ContactHotel ContactDetails) throws ResourceNotFoundException {
		

		contactHotelImpl.updateContactHotel(idContact, ContactDetails);
		log.info("update contact hotel avec id ="+idContact);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable(value = "id") Long idContact) {
		log.info("suppression contact fournisseur avec id= "+idContact);
		try {
			contactHotelImpl.deleteById(idContact);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
