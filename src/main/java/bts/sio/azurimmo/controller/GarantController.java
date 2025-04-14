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
import bts.sio.azurimmo.model.Garant;
import bts.sio.azurimmo.repository.ContratRepository;
import bts.sio.azurimmo.repository.GarantRepository;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/garants")
public class GarantController {

	@Autowired
	private GarantRepository garantRepository;
	
	@Autowired
    private ContratRepository contratRepository;
	
	@GetMapping
	public List<Garant> getAllGarants() {
	    return garantRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Garant> getGarantById(@PathVariable Long id) {
	    return garantRepository.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/contrat/{contratId}")
	public List<Garant> getGarantsByContrat(@PathVariable Long contratId) {
	    return garantRepository.findByContrat_Id(contratId);
	}
	
	@PostMapping
	public ResponseEntity<Garant> createGarant(@RequestBody Garant garant) {
	    if (garant.getContrat() != null && garant.getContrat().getId() != null) {
	        Long contratId = garant.getContrat().getId();
	        contratRepository.findById(contratId).ifPresent(garant::setContrat);
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    Garant saved = garantRepository.save(garant);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Garant> updateGarant(
	    @PathVariable Long id,
	    @RequestBody Garant garantDetails
	) {
	    return garantRepository.findById(id)
	        .map(garant -> {
	            garant.setNom(garantDetails.getNom());
	            garant.setPrenom(garantDetails.getPrenom());

	            Garant updated = garantRepository.save(garant);
	            return ResponseEntity.ok(updated);
	        })
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGarant(@PathVariable Long id) {
		if (!garantRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		garantRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}