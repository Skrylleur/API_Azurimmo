package bts.sio.azurimmo.repository;
import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Contrat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long>{

	List<Contrat> findByAppartementId(Long appartementId);
	
}