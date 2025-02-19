package bts.sio.azurimmo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.repository.ContratRepository;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;

    // Nouveau point de terminaison pour renvoyer une liste simple
    @GetMapping("/")
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
}
