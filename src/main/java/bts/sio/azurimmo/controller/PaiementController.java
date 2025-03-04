package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/paiements")
	public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
		//Vérifier et transformer l'ID = 0 en null
		if (paiement.getId() != null && paiement.getId() == 0) {
			paiement.setId(null);
		}
		
		Paiement savedPaiement = paiementRepository.save(paiement);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPaiement);
	}
}
