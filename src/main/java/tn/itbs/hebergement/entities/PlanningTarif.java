package tn.itbs.hebergement.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PlanningTarif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTarif;
	private int nbr_pax;
	@CreatedDate
	private LocalDateTime dateTarif;
	private double prixAchat;
	private double prixVente;
	private double commission;
	private double supplementPaxAchat;
	private double supplementPaxVente;
	private double supplementPd;
	private double taxeSejour;
	private int prixMode;
	private int prixModeAchat;
	private int planning;
	@OneToOne
	private Hotel hotel;
	@OneToOne
	private TypeChambre typeChambre;
	
	
}
