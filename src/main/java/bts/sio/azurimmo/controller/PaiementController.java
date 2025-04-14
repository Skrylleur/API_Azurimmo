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
import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.repository.ContratRepository;
import bts.sio.azurimmo.repository.PaiementRepository;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

	@Autowired
	private PaiementRepository paiementRepository;
	
	@Autowired
	private ContratRepository contratRepository;
	
	@GetMapping
	public List<Paiement> getAllPaiements() {
		return paiementRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
	    return paiementRepository.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/contrat/{contratId}")
	public List<Paiement> getPaiementsByContrat(@PathVariable Long contratId) {
	    return paiementRepository.findByContrat_Id(contratId);
	}

	@PostMapping
	public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
	    if (paiement.getContrat() != null && paiement.getContrat().getId() != null) {
	        Long contratId = paiement.getContrat().getId();
	        contratRepository.findById(contratId).ifPresent(paiement::setContrat);
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    Paiement saved = paiementRepository.save(paiement);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
	    return paiementRepository.findById(id)
	        .map(paiement -> {
	            paiement.setMontant(paiementDetails.getMontant());
	            paiement.setDatePaiement(paiementDetails.getDatePaiement());
	            Paiement updated = paiementRepository.save(paiement);
	            return ResponseEntity.ok(updated);
	        })
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
	    if (!paiementRepository.existsById(id)) {
	        return ResponseEntity.notFound().build();
	    }

	    paiementRepository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
}