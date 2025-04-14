package bts.sio.azurimmo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "locataire")
public class Locataire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "dateN")
	private Date dateN;
	
	@Column(name = "lieuN")
	private String lieuN;
	
	@ManyToOne
	@JoinColumn(name = "contrat_id", nullable = false)
	@JsonIgnoreProperties("locataires")
	private Contrat contrat;
	
	//Ajout des guetters et setters
	//Id
	public Long getId() {
	return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	//Nom
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Prénom
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//DateN
	public Date getDateN() {
		return dateN;
	}
	
	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}
	
	//LieuN
	public String getLieuN() {
		return lieuN;
	}
	
	public void setLieuN(String lieuN) {
		this.lieuN = lieuN;
	}
	
	public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat= contrat;
    }

}
