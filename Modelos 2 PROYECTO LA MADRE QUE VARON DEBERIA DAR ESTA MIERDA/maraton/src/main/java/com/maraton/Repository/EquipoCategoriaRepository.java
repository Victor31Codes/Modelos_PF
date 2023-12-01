package com.maraton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maraton.Entidades.EquipoCategoria;

public interface EquipoCategoriaRepository extends JpaRepository<EquipoCategoria,Long> {
	
	@Query("SELECT COALESCE(MAX(e.idEquipocat), 0) FROM EquipoCategoria e")
	Integer findMaxidEquipocat();

}
