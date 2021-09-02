package tn.itbs.hebergement.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class PlanningTarif implements Serializable {
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
	@ManyToOne(fetch = FetchType.LAZY)
	private Hotel hotel;
	@OneToOne
	private TypeChambre typeChambre;
	
	
}
