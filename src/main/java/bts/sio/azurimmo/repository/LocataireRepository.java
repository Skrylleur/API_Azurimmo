package bts.sio.azurimmo.repository;
import bts.sio.azurimmo.model.Locataire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepository extends JpaRepository<Locataire, Long> {
    List<Locataire> findByContrat_Id(Long contratId);
}