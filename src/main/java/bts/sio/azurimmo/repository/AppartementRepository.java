package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Appartement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {

	List<Appartement> findByBatiment_Ville(String ville);

	List<Appartement> findByBatiment_Id(long id);

	List<Appartement> findBySurfaceGreaterThan(float surface);

}
