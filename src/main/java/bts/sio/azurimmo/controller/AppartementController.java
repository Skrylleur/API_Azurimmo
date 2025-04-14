package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController
@RequestMapping("/api/appartements")
public class AppartementController {

    @Autowired
    private AppartementService appartementService;

    @Autowired
    private AppartementRepository appartementRepository;

    @GetMapping
    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }

    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }

    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
        return appartementService.getAppartementsParBatiment(batimentId);
    }

    @GetMapping("/surface/{surface}")
    public List<Appartement> findBySurfaceGreaterThan(@PathVariable float surface) {
        return appartementService.findBySurfaceGreaterThan(surface);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appartement> getAppartementById(@PathVariable Long id) {
        return appartementRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Appartement> createAppartement(@RequestBody Appartement appartement) {
        if (appartement.getId() != null && appartement.getId() == 0) {
            appartement.setId(null);
        }

        Appartement savedAppartement = appartementRepository.save(appartement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppartement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appartement> updateAppartement(@PathVariable Long id, @RequestBody Appartement appartementDetails) {
        return appartementRepository.findById(id)
                .map(appartement -> {
                    appartement.setNumero(appartementDetails.getNumero());
                    appartement.setSurface(appartementDetails.getSurface());
                    appartement.setNbPieces(appartementDetails.getNbPieces());
                    appartement.setDescription(appartementDetails.getDescription());
                    return ResponseEntity.ok(appartementRepository.save(appartement));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppartement(@PathVariable Long id) {
        if (!appartementRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        appartementRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}