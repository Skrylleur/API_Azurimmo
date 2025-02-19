package bts.sio.azurimmo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.repository.InterventionRepository;
import lombok.Data;

@Data
@Service
public class InterventionService {
	@Autowired
	private InterventionRepository interventionRepository;
	
	public Intervention saveIntervention(Intervention intervention) {
		Intervention savedIntervention = interventionRepository.save(intervention);
		return savedIntervention;
	}
}