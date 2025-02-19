package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.repository.InterventionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

    @Autowired
    private InterventionRepository interventionRepository;

    // Nouveau point de terminaison pour renvoyer une liste simple
    @GetMapping("/")
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }
}
