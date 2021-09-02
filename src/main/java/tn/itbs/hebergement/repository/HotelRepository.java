package tn.itbs.hebergement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


import tn.itbs.hebergement.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	Page<Hotel> findByNom(String nom,Pageable pageable);
	List<Hotel> findByAdresse(String adresse);
	List<Hotel> findByEtat(boolean etat);
}
