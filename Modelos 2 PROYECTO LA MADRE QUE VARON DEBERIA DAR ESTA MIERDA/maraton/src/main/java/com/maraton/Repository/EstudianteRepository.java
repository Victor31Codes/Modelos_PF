package com.maraton.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maraton.Entidades.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

	List<EstudianteProjection> findAllProjectedBy();
	
	Optional<Estudiante>findProfileByCodigo(Long aLong);
	
	Estudiante findEstudianteByCodigo(Long aLong);
}
