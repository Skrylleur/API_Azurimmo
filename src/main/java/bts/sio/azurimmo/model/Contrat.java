package bts.sio.azurimmo.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contrat")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dateEntree")
	private Date dateEntree;
	
	@Column(name = "dateSortie")
	private Date dateSortie;
	
	@Column(name = "montantLoyer")
	private double montantLoyer;
	
	@Column(name = "montantCharges")
	private double montantCharges;
	
	@Column(name = "statut")
	private String statut;

	@ManyToOne
    @JoinColumn(name = "appartement_id")
    private Appartement appartement;
	
	@OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Paiement> paiements;

	@OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Locataire> locataires;

	@OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("contrat")
	private List<Garant> garants;
	
	//Ajout des getters et setters
	//Id
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //dateEntree
    public Date getDateEntree() {
    	return dateEntree;
    }
    
    public void setDateEntree(Date dateEntree) {
    	this.dateEntree = dateEntree;
    }
    
    //dateSortie
    public Date getDateSortie() {
    	return dateSortie;
    }
    
    public void setDateSortie(Date dateSortie) {
    	this.dateSortie = dateSortie; 
    }
    
    //montantLoyer
    public double getMontantLoyer() {
    	return montantLoyer;
    }
    
    public void setMontantLoyer(double montantLoyer) {
    	this.montantLoyer = montantLoyer;
    }
    
    //montantCharges
    public double getMontantCharges() {
    	return montantCharges;
    }
    
    public void setMontantCharges(double montantCharges) {
    	this.montantCharges = montantCharges;
    }
    
    //statut
    public String getStatut() {
    	return statut;
    }
    
    public void setStatut(String statut) {
    	this.statut = statut;
    }
    
    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }
    
}