package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Batiment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {

	Optional<Batiment> findById(Long id);
}
