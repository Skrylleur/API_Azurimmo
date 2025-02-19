package bts.sio.azurimmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.repository.PaiementRepository;
import lombok.Data;

@Data
@Service
public class PaiementService {

	@Autowired
	private PaiementRepository paiementRepository;
	
	public Paiement savePaiement(Paiement paiement) {
		Paiement savedPaiement = paiementRepository.save(paiement);
		return savedPaiement;
	}
}
