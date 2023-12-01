package com.maraton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;

import com.maraton.Entidades.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo,Long>{
	
	@Query("SELECT COALESCE(MAX(e.idEquipo), 0) FROM Equipo e")
    Integer findMaxIdEquipo();
	
	Equipo findBynombreequipo(String nombreequipo);
	

}
