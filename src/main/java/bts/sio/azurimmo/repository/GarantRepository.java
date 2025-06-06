package bts.sio.azurimmo.repository;
import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Garant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GarantRepository extends JpaRepository<Garant, Long>{
	List<Garant> findByContrat_Id(Long contratId);
}