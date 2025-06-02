package bts.sio.azurimmo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import bts.sio.azurimmo.model.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByBatimentId(Long batimentId);
}