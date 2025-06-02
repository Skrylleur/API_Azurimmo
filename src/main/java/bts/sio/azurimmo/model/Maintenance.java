package bts.sio.azurimmo.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeInter")
    private String typeInter;

    @Column(name = "dateInter")
    private Date dateInter;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "nomIntervenant")
    private String nomIntervenant;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequence")
    private FrequenceMaintenance frequence;

    @ManyToOne
    @JoinColumn(name = "batiment_id")
    private Batiment batiment;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeInter() {
        return typeInter;
    }

    public void setTypeInter(String typeInter) {
        this.typeInter = typeInter;
    }

    public Date getDateInter() {
        return dateInter;
    }

    public void setDateInter(Date dateInter) {
        this.dateInter = dateInter;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNomIntervenant() {
        return nomIntervenant;
    }

    public void setNomIntervenant(String nomIntervenant) {
        this.nomIntervenant = nomIntervenant;
    }

    public FrequenceMaintenance getFrequence() {
        return frequence;
    }

    public void setFrequence(FrequenceMaintenance frequence) {
        this.frequence = frequence;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
}