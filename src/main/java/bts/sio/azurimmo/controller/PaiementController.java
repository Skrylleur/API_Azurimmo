package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.repository.PaiementRepository;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

	@Autowired
	private PaiementRepository paiementRepository;
	
	@GetMapping("/")
	public List<Paiement> getAllPaiements() {
		return paiementRepository.findAll();
	}
}
