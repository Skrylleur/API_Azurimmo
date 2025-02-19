package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.Garant;
import bts.sio.azurimmo.repository.GarantRepository;

@RestController
@RequestMapping("/api/garants")
public class GarantController {

	@Autowired
	private GarantRepository garantRepository;
	
	//Nouveau point de terminaison pour renvoyer une liste simple
	@GetMapping("/")
	public List<Garant> getAllGarants() {
		return garantRepository.findAll();
	}
}
