package tn.itbs.hebergement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.HotelRepository;

@Service
@Slf4j
@Transactional
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
			
		return hotelRepository.save(hotel);
	}

	@Override
	public Page<Hotel> getAllHotels(PageRequest pageRequest) {
		return hotelRepository.findAll(pageRequest);
	}

	@Override
	public Hotel getHotelById(Long id) throws ResourceNotFoundException {		
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel avec l'id = "+ id +" introuvable "));
	}

	@Override
	public Page<Hotel> getHotelByNom(String nom,PageRequest pageRequest) throws ResourceNotFoundException {
		return hotelRepository.findByNom(nom, pageRequest);
				
	}

	@Override
	public List<Hotel> getHotelByAdresse(String adresse) throws ResourceNotFoundException {
		return hotelRepository.findByAdresse(adresse);
	}

	@Override
	public List<Hotel> getHotelByEtat(boolean etat) throws ResourceNotFoundException {
		
		return hotelRepository.findByEtat(etat);
	}

	@Override
	public Hotel updateHotel(Long id, Hotel hotelDetails) throws ResourceNotFoundException {
		Hotel hotel = hotelRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel avec l'id = "+ id +" introuvable "));
		hotel.setNom(hotelDetails.getNom());
		hotel.setAdresse(hotelDetails.getAdresse());
		hotel.setEmail(hotelDetails.getEmail());
		hotel.setCapaciteGlobal(hotelDetails.getCapaciteGlobal());
		hotel.setCategorie(hotelDetails.getCategorie());
		hotel.setCodePostal(hotelDetails.getCodePostal());
		hotel.setHoraire(hotelDetails.getHoraire());
		hotel.setEtat(hotelDetails.isEtat());
		hotel.setImmatriculation(hotelDetails.getImmatriculation());
		hotel.setLogo(hotelDetails.getLogo());
		hotel.setPays(hotelDetails.getPays());
		hotel.setNombreDeChambre(hotelDetails.getNombreDeChambre());
		hotel.setNombreEtages(hotelDetails.getNombreEtages());
		hotel.setNumeroSiret(hotelDetails.getNumeroSiret());
		//hotel.setContactHotel(hotelDetails.getContactHotel());
		
	
		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteById(Long id) throws ResourceNotFoundException {
		Hotel hotel =
				hotelRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Hotel avec l'id = "+ id +" introuvable "));
		hotelRepository.delete(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotelsAll() {
		
		return hotelRepository.findAll();
	}

	

}
