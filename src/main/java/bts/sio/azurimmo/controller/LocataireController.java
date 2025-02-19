package bts.sio.azurimmo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.repository.LocataireRepository;

@RestController
@RequestMapping("/api/locataires")
public class LocataireController {

	@Autowired
	private LocataireRepository locataireRepository;
	
	@GetMapping("/")
	public List<Locataire> getAllLocataires() {
		return locataireRepository.findAll();
	}
}
