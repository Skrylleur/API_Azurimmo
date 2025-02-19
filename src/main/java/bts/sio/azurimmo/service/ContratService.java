package bts.sio.azurimmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.repository.ContratRepository;
import lombok.Data;

@Data
@Service
public class ContratService {
	@Autowired
	private ContratRepository contratRepository;
	
	public Contrat saveContrat(Contrat contrat) {
		Contrat savedContrat = contratRepository.save(contrat);
		return savedContrat;
	}
}