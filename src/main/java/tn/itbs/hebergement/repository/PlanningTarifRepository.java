package tn.itbs.hebergement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.hebergement.entities.Chambre;
import tn.itbs.hebergement.entities.PlanningTarif;

public interface PlanningTarifRepository extends JpaRepository<PlanningTarif, Long> {
	PlanningTarif findPlanningTarifByHotel_Nom(String nomHotel);
	Page<PlanningTarif> findPlanningTarifByTypeChambre_Nom (String typeChambre, Pageable pageable);

}
