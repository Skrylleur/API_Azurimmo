package bts.sio.azurimmo.repository;
import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Intervention;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
	
	List<Intervention> findByAppartementId(Long appartementId);
	
}