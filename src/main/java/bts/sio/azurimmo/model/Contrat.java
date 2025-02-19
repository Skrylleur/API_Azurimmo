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
@Table(name = "contrat")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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

    //Relation ManyToOne avec la classe Appartement
    @ManyToOne
    @JoinColumn(name = "appartement_id")
    private Appartement appartement;    

    //Relation ManyToOne avec la classe Garant
    @ManyToOne
    @JoinColumn(name = "garant_id")
    private Garant garant;
    
    //Relation ManyToOne avec la classe Locataire
    @ManyToOne
    @JoinColumn(name = "locataire")
    private Locataire locataire;
}