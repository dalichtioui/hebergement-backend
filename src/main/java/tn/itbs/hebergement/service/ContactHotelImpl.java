package tn.itbs.hebergement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.ContactHotel;
import tn.itbs.hebergement.exceptions.ResourceNotFoundException;
import tn.itbs.hebergement.repository.ContactHotelRepository;

@Service
@Slf4j
@Transactional
public class ContactHotelImpl implements IContactHotelService {
	
	@Autowired
	private ContactHotelRepository contactHotelRepository;

	@Override
	public ContactHotel createContactHotel(ContactHotel contactHotel) {
		
		return contactHotelRepository.save(contactHotel);
	}

	@Override
	public List<ContactHotel> getAllContactHotels() {
		
		return contactHotelRepository.findAll();
	}

	@Override
	public ContactHotel getContactHotelById(Long id) throws ResourceNotFoundException {
		
		return contactHotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact Hotel avec l'id = "+ id +" introuvable "));
	}

	@Override
	public List<ContactHotel> getContactHotelByNom(String nom) throws ResourceNotFoundException {
		
		return contactHotelRepository.findByNom(nom);
	}

	

	@Override
	public ContactHotel updateContactHotel(Long id, ContactHotel contactHotelDetails)
			throws ResourceNotFoundException {
		ContactHotel contactHotel = contactHotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact Hotel avec l'id = "+ id +" introuvable "));
		contactHotel.setNom(contactHotelDetails.getNom());
	
		contactHotel.setEmail(contactHotelDetails.getEmail());
		contactHotel.setFax(contactHotelDetails.getFax());
		contactHotel.setFonction(contactHotelDetails.getFonction());
		contactHotel.setMobile(contactHotelDetails.getMobile());
		contactHotel.setTelephone(contactHotelDetails.getTelephone());
		contactHotel.setEtat(contactHotelDetails.isEtat());

		return contactHotelRepository.save(contactHotel);
	}

	@Override
	public void deleteById(Long id) throws ResourceNotFoundException {
		ContactHotel ContactHotel =
				contactHotelRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Hotel avec l'id = "+ id +" introuvable "));
		contactHotelRepository.delete(ContactHotel);
		
		
	}

}
