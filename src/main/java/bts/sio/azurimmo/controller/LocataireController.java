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
import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.repository.ContratRepository;
import bts.sio.azurimmo.repository.LocataireRepository;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/locataires")
public class LocataireController {

	@Autowired
	private LocataireRepository locataireRepository;
	
	@Autowired
    private ContratRepository contratRepository;
	
	@GetMapping
	public List<Locataire> getAllLocataires() {
		return locataireRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Locataire> getLocataireById(@PathVariable Long id) {
	    return locataireRepository.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/contrat/{contratId}")
	public List<Locataire> getLocatairesByContrat(@PathVariable Long contratId) {
	    return locataireRepository.findByContrat_Id(contratId);
	}
	
	@PostMapping
	public ResponseEntity<Locataire> createLocataire(@RequestBody Locataire locataire) {
	    if (locataire.getContrat() != null && locataire.getContrat().getId() != null) {
	        Long contratId = locataire.getContrat().getId();
	        contratRepository.findById(contratId).ifPresent(locataire::setContrat);
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    Locataire saved = locataireRepository.save(locataire);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Locataire> updateLocataire(@PathVariable Long id, @RequestBody Locataire locataireDetails) {
		return locataireRepository.findById(id)
				.map(locataire ->{
					locataire.setNom(locataireDetails.getNom());
					locataire.setPrenom(locataireDetails.getPrenom());
					locataire.setDateN(locataireDetails.getDateN());
					locataire.setLieuN(locataireDetails.getLieuN());
					Locataire updated = locataireRepository.save(locataire);
					return ResponseEntity.ok(updated);
				})
				.orElse(ResponseEntity.notFound().build());
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLocataire(@PathVariable Long id) {
		if (!locataireRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		locataireRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
