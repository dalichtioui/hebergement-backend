package tn.itbs.hebergement.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;
	private String nom;													
	private String email;
	private String adresse;
	private Long codePostal;
	private String pays;
	private String horaire;
	private int nombreDeChambre;
	private int capaciteGlobal;
	private String categorie;
	private String nombreEtages;
	private Long numeroSiret;
	private String immatriculation;
	private byte[] logo;
	private boolean etat;
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ContactHotel contactHotel;*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<ContactHotel> contacts;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Chambre> chambres;
	@OneToOne
	private PlanningTarif planningTrafif;
	
	
	
	
	
}
