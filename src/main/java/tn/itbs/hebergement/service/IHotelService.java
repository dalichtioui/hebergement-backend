package tn.itbs.hebergement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.itbs.hebergement.entities.Hotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;

public interface IHotelService {
	
	Hotel createHotel(Hotel fournisseur);
	
	Page<Hotel> getAllHotels(PageRequest pagerequest);
	
	List<Hotel> getAllHotelsAll( );

	Hotel getHotelById(Long id) throws ResourceNotFoundException;
	
	Page<Hotel> getHotelByNom(String nom, PageRequest pageRequest) throws ResourceNotFoundException;
	
	List<Hotel> getHotelByAdresse(String Adresse) throws ResourceNotFoundException;
	
	Hotel updateHotel(Long id, Hotel fournisseurDetails) throws ResourceNotFoundException;
	
	void deleteById(Long id) throws ResourceNotFoundException;
	
	List<Hotel> getHotelByEtat(boolean etat) throws ResourceNotFoundException;
	
}
