package bts.sio.azurimmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Garant;
import bts.sio.azurimmo.repository.GarantRepository;
import lombok.Data;

@Data
@Service
public class GarantService {
	@Autowired
	private GarantRepository garantRepository;
	
	public Garant saveGarant(Garant garant) {
		Garant savedGarant = garantRepository.save(garant);
		return savedGarant;
	}
}