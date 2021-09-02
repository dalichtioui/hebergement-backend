package tn.itbs.hebergement.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.service.CsvServiceHotel;
import tn.itbs.hebergement.service.HotelServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	@Autowired
	private CsvServiceHotel csvServiceHotel;

	@GetMapping("/hotels")
	public Page<Hotel> getAllHotels(
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size
			
			) {
		
		return hotelServiceImpl.getAllHotels(
				PageRequest.of(page, size));
	}
	@GetMapping("/hotelslAll")
	public List<Hotel> getAllHotelsAll(){
		return hotelServiceImpl.getAllHotelsAll();
	}
	

	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(value = "id") Long idHotel)
			throws ResourceNotFoundException {
		Hotel hotel = hotelServiceImpl.getHotelById(idHotel);
		return ResponseEntity.ok().body(hotel);
	}

	@PostMapping("/hotels")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> createHotel(@Valid @RequestBody Hotel hotel) {
		try {
			hotelServiceImpl.createHotel(hotel);
			log.info("ajout hotel");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/hotels/{id}")
	public ResponseEntity<HttpStatus> updateHotel(@PathVariable(value = "id") Long idHotel,
			@Valid @RequestBody Hotel hotelDetails) throws ResourceNotFoundException {
		log.info("update hotel");
		hotelServiceImpl.updateHotel(idHotel, hotelDetails);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<HttpStatus> deleteProduit(@PathVariable(value = "id") Long idHotel) {
		log.info("suppression hotel avec id"+idHotel);
		try {
			hotelServiceImpl.deleteById(idHotel);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/hotels/adresse")
	public ResponseEntity<List<Hotel>> getHotelByAdresse(@RequestParam String adresse)
			throws ResourceNotFoundException {
		return new ResponseEntity<List<Hotel>>(hotelServiceImpl.getHotelByAdresse(adresse),
				HttpStatus.OK);
	}

	@GetMapping("/hotels/etat")
	public ResponseEntity<List<Hotel>> getHotelByEtat(@RequestParam boolean etat)
			throws ResourceNotFoundException {
		return new ResponseEntity<List<Hotel>>(hotelServiceImpl.getHotelByEtat(etat), HttpStatus.OK);
	}

	@GetMapping("/hotels/nom")
	public ResponseEntity<Page<Hotel>> getHotelsByNom(@RequestParam String nom,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size)
			throws ResourceNotFoundException {
		return new ResponseEntity<Page<Hotel>>(hotelServiceImpl.getHotelByNom(nom,PageRequest.of(page, size)), HttpStatus.OK);
	}

	@GetMapping("/hotels/download")
	public ResponseEntity<Resource> getCsv(@RequestHeader(name = "Content-disposition") final String fileName,
			@RequestHeader(name = "Content-Type") final String mediaType) {
		log.info("Telechargement du csv");
		final List<Hotel> hotels = hotelServiceImpl.getAllHotelsAll();
		final InputStreamResource resource = new InputStreamResource(csvServiceHotel.load(hotels));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, fileName)
				.contentType(MediaType.parseMediaType(mediaType)).body(resource);
	}

	/*@GetMapping("/hotels/download-by-nom")
	public ResponseEntity<Resource> getCsvByNom(@RequestHeader(name = "Content-disposition"
	) final String fileName,
			@RequestHeader(name = "Content-Type") final String mediaType, @RequestParam String nom,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue= "4")int size)
			throws ResourceNotFoundException {
		log.info("Telechargement du csv");
		final Page<Hotel> hotels = hotelServiceImpl.getHotelByNom(nom,PageRequest.of(page, size));
		final InputStreamResource resource = new InputStreamResource(csvServiceHotel.load(hotels));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, fileName)
				.contentType(MediaType.parseMediaType(mediaType)).body(resource);
	}*/

	@GetMapping("/fournisseurs/download-by-Adresse")
	public ResponseEntity<Resource> getCsvByAdresse(@RequestHeader(name = "Content-disposition") final String fileName,
			@RequestHeader(name = "Content-Type") final String mediaType, @RequestParam String adresse)
			throws ResourceNotFoundException {
		log.info("Telechargement du csv");
		final List<Hotel> hotels = hotelServiceImpl.getHotelByAdresse(adresse);
		final InputStreamResource resource = new InputStreamResource(csvServiceHotel.load(hotels));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, fileName)
				.contentType(MediaType.parseMediaType(mediaType)).body(resource);
	}

}
