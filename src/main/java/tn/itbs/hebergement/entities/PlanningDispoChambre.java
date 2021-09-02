package tn.itbs.hebergement.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PlanningDispoChambre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDispo;
	private LocalDate dateDispo;
	private boolean etat_fermer;
	private boolean etat_bloquer;
	private String duree_option;
	

}
