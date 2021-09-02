package tn.itbs.hebergement.service;

import java.util.List;

import tn.itbs.hebergement.entities.ContactHotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;


public interface IContactHotelService {
	ContactHotel createContactHotel(ContactHotel contactFournisseur);
	
	List<ContactHotel> getAllContactHotels();
	
	ContactHotel getContactHotelById(Long id) throws ResourceNotFoundException;
	
	List<ContactHotel> getContactHotelByNom(String nom) throws ResourceNotFoundException;
	
	
	ContactHotel updateContactHotel(Long id, ContactHotel contactFournisseurDetails) throws ResourceNotFoundException;
	
	void deleteById(Long id) throws ResourceNotFoundException;
}
