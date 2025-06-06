package bts.sio.azurimmo.repository;

import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Paiement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long>{
	List<Paiement> findByContrat_Id(Long contratId);
}