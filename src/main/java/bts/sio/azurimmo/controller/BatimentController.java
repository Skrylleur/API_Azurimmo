package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.BatimentRepository;
import bts.sio.azurimmo.service.BatimentService;
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

@RestController
@RequestMapping("/api/batiments")
//@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@CrossOrigin(origins = "*")
public class BatimentController {

    @Autowired
    private BatimentRepository batimentRepository;
    @Autowired
    private BatimentService batimentService;
 
	@GetMapping
	public List<Batiment> getAllBatiments() {
		return batimentRepository.findAll();
	}

    @GetMapping("/{id}") // <-- Ceci permet d'accéder à /api/batiments/1
    public ResponseEntity<Batiment> getBatimentById(@PathVariable Long id) {
        return batimentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
	@PostMapping
	public ResponseEntity<Batiment> createBatiment(@RequestBody Batiment batiment) {
		if (batiment.getId() != null && batiment.getId() == 0) {
			batiment.setId(null);
		}
		
		Batiment savedBatiment = batimentRepository.save(batiment);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBatiment);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Batiment> updateBatiment(@PathVariable Long id, @RequestBody Batiment batimentDetails) {
		return batimentRepository.findById(id)
				.map(batiment ->{
					batiment.setAdresse(batimentDetails.getAdresse());
					batiment.setVille(batimentDetails.getVille());
					Batiment updated = batimentRepository.save(batiment);
					return ResponseEntity.ok(updated);
				})
				.orElse(ResponseEntity.notFound().build());
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBatiment(@PathVariable Long id) {
		if (!batimentRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		batimentRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}