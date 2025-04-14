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
	private Long id;
	
	@Column(name = "montant")
	private Double montant;
	
	@Column(name = "datePaiement")
	private Date datePaiement;
	
	//Relation ManyToOne avec la classe Contrat
	@ManyToOne
	@JoinColumn(name = "contrat_id", nullable = false)
	private Contrat contrat;
		
	//Ajout des getters et setters
	//Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Contrat getContrat() {
	    return contrat;
	}

	public void setContrat(Contrat contrat) {
	    this.contrat = contrat;
	}
	
}
