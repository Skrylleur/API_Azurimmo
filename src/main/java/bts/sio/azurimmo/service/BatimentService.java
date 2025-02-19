package bts.sio.azurimmo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.BatimentRepository;

@Service
public class BatimentService {
    
    @Autowired
    private BatimentRepository batimentRepository;

    public Batiment saveBatiment(Batiment batiment) {
        if (batiment.getId() == 0) {
            batiment.setId(null);
        }
        return batimentRepository.save(batiment);
    }
    
    public boolean deleteBatiment(Long batimentId) {
    	Optional<Batiment> optBat=batimentRepository.findById(batimentId);
    	if(optBat.isPresent()) {
    		batimentRepository.delete(optBat.get());
    		return true;
    	}
    	return false;
    }
}
