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
@Table(name = "intervention")
public class Intervention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="typeInter")
	private String typeInter;
	
	@Column(name="dateInter")
	private Date dateInter;

	//Ajout des getters et setters
	//Id
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
    //Description
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    //TypeInter
    public String getTypeInter() {
    	return typeInter;
    }
    
    public void setTypeInter(String typeInter) {
    	this.typeInter= typeInter;
    }
    
    //DateInter
    public Date getDateInter() {
    	return dateInter;
    }
    
    public void setDateInter(Date dateInter) {
    	this.dateInter = dateInter;
    }
    
    //Relation ManyToOne avec la classe Appartement
    @ManyToOne
    @JoinColumn(name = "appartement_id")
    private Appartement appartement;

}