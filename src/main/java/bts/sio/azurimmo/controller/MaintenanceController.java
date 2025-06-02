package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.azurimmo.model.Maintenance;
import bts.sio.azurimmo.repository.MaintenanceRepository;

@RestController
@RequestMapping("/api/maintenances")
@CrossOrigin(origins = "*")
public class MaintenanceController {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @GetMapping("/batiment/{batimentId}")
    public List<Maintenance> getByBatiment(@PathVariable Long batimentId) {
        return maintenanceRepository.findByBatimentId(batimentId);
    }
}