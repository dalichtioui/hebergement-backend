package tn.itbs.hebergement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;


import tn.itbs.hebergement.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
	Page<Chambre> findChambreByTypeChambre_Nom(String chambreNom, Pageable pageable);
	Page<Chambre> findByEtat(boolean etat, PageRequest pageRequest);
}
