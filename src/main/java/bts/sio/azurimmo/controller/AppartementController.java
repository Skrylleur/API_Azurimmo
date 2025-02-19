package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartements")
public class AppartementController {

    @Autowired
    private AppartementService appartementService;
    
    @Autowired
    private AppartementRepository appartementRepository;
 
    // Récupérer les appartements par ville
    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }

    // Récupérer les appartements par ID de bâtiment
    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
        return appartementService.getAppartementsParBatiment(batimentId);
    }

    // Récupérer les appartements ayant une surface supérieure à un seuil
    @GetMapping("/surface/{surface}")
    public List<Appartement> findBySurfaceGreaterThan(@PathVariable float surface) {
        return appartementService.findBySurfaceGreaterThan(surface);
    }

    // Récupérer tous les appartements
    @GetMapping("/")
    public List<Appartement> getAllAppartements() {
        return appartementService.findAllAppartements();
    }

    // Ajouter un appartement
    @PostMapping("/")
    public ResponseEntity<Appartement> createAppartement(@RequestBody Appartement appartement) {
        // Vérifier et transformer l'ID = 0 en null
        if (appartement.getId() != null && appartement.getId() == 0) {
            appartement.setId(null);
        }
        Appartement savedAppartement = appartementRepository.save(appartement);
        return ResponseEntity.ok(savedAppartement);
    }
}
