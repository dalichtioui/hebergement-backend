package tn.itbs.hebergement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class GroupeHotel {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupeHotelId;
	private String nom;
	private String description;
	private boolean etat;
	
}
