package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.InterventionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

    @Autowired
    private InterventionRepository interventionRepository;
    
    @Autowired
    private AppartementRepository appartementRepository;
    
	@GetMapping
	public List<Intervention> getAllInterventions() {
		return interventionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
	    return interventionRepository.findById(id)
	        .map(intervention -> ResponseEntity.ok(intervention))
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/appartement/{appartementId}")
	public List<Intervention> getInterventionsByAppartement(@PathVariable Long appartementId) {
	    return interventionRepository.findByAppartementId(appartementId);
	}
	
	@PostMapping
	public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
	    if (intervention.getAppartement() != null && intervention.getAppartement().getId() != null) {
	        Long appartId = intervention.getAppartement().getId();
	        appartementRepository.findById(appartId).ifPresent(intervention::setAppartement);
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    Intervention saved = interventionRepository.save(intervention);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention interventionDetails) {
		return interventionRepository.findById(id)
				.map(intervention ->{
					intervention.setDescription(interventionDetails.getDescription());
					intervention.setTypeInter(interventionDetails.getTypeInter());
					intervention.setDateInter(interventionDetails.getDateInter());
					Intervention updated = interventionRepository.save(intervention);
					return ResponseEntity.ok(updated);
				})
				.orElse(ResponseEntity.notFound().build());
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
		if (!interventionRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		interventionRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
