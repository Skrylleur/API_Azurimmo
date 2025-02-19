package bts.sio.azurimmo.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "paiement")
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "montant")
	private Double montant;
	
	@Column(name = "datePaiement")
	private Date datePaiement;
	
	//Ajout des getters et setters
	//Id
	public Long setId() {
		return id;
	}
	
	public void getId(Long id) {
		this.id = id;
	}
	
	//Montant
	public Double getMontant() {
		return montant;
	}
	
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	//DatePaiement
	public Date getDatePaiement() {
		return datePaiement;
	}
	
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	
	//Relation ManyToOne avec la classe Contrat
	@ManyToOne
	@JoinColumn(name = "contrat_id")
	private Contrat contrat;
}
