package bts.sio.azurimmo.controller;

import java.util.List;

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

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.ContratRepository;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/contrats")
public class ContratController {

	@Autowired
	private ContratRepository contratRepository;
	
	@Autowired
    private AppartementRepository appartementRepository;
	
	@GetMapping
	public List<Contrat> getAllContrats() {
		return contratRepository.findAll();
	}
	
	@GetMapping("/appartement/{appartementId}")
	public List<Contrat> getContratsByAppartement(@PathVariable Long appartementId) {
	    return contratRepository.findByAppartementId(appartementId);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        return contratRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
	public ResponseEntity<Contrat> createContrat(@RequestBody Contrat contrat) {
	    if (contrat.getAppartement() != null && contrat.getAppartement().getId() != null) {
	        Long appartId = contrat.getAppartement().getId();
	        appartementRepository.findById(appartId).ifPresent(contrat::setAppartement);
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    Contrat saved = contratRepository.save(contrat);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contratDetails) {
	    return contratRepository.findById(id)
	        .map(contrat -> {
	            contrat.setDateEntree(contratDetails.getDateEntree());
	            contrat.setDateSortie(contratDetails.getDateSortie());
	            contrat.setMontantLoyer(contratDetails.getMontantLoyer());
	            contrat.setMontantCharges(contratDetails.getMontantCharges());
	            contrat.setStatut(contratDetails.getStatut());
	            Contrat updated = contratRepository.save(contrat);
	            return ResponseEntity.ok(updated);
	        })
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
	    if (!contratRepository.existsById(id)) {
	        return ResponseEntity.notFound().build();
	    }

	    contratRepository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
}