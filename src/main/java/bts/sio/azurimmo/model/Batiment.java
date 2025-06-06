package bts.sio.azurimmo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "batiment")

public class Batiment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="ville")
	private String ville;

	public Long getId() {
        return id;
    }

	@OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL, orphanRemoval = true)
	@com.fasterxml.jackson.annotation.JsonManagedReference
	private List<Appartement> appartements;	
	
    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

	public static Batiment saveBatiment(Batiment batiment) {
		// TODO Auto-generated method stub
		return null;
	}
}

