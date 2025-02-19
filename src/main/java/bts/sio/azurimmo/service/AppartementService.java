package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.repository.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppartementService {

    @Autowired
    private AppartementRepository appartementRepository;

    // Récupérer tous les appartements
    public List<Appartement> findAllAppartements() {
        return appartementRepository.findAll();
    }

    // Récupérer les appartements par ville
    public List<Appartement> findByVille(String ville) {
        return appartementRepository.findByBatiment_Ville(ville);
    }

    // Récupérer les appartements appartenant à un bâtiment spécifique
    public List<Appartement> getAppartementsParBatiment(long batimentId) {
        return appartementRepository.findByBatiment_Id(batimentId);
    }

    // Récupérer les appartements ayant une surface supérieure à une valeur donnée
    public List<Appartement> findBySurfaceGreaterThan(float surface) {
        return appartementRepository.findBySurfaceGreaterThan(surface);
    }
    
    public Appartement saveAppartement(Appartement appartement) {
        if (appartement.getId() == 0) {
            appartement.setId(null);
        }
        return appartementRepository.save(appartement);
    }
}
