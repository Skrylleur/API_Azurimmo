package bts.sio.azurimmo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "appartement")
public class Appartement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "surface")
    private float surface;

    @Column(name = "nbPieces")
    private int nbPieces;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "batiment_id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Batiment batiment;
    
    @OneToMany(mappedBy = "appartement", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Intervention> interventions;

	@OneToMany(mappedBy = "appartement", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contrat> contrats;
	
    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour numero
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter et Setter pour surface
    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    // Getter et Setter pour nbPieces
    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    // Getter et Setter pour description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et Setter pour batiment
    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
}
