package tn.itbs.hebergement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.hebergement.entities.ContactHotel;

public interface ContactHotelRepository extends JpaRepository<ContactHotel, Long>{
	List<ContactHotel> findByNom(String nom);

}
