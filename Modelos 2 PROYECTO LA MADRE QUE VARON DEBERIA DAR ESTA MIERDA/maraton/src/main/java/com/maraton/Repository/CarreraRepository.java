package com.maraton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraton.Entidades.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera,Long>  {
	
	Carrera findCarreraByidCarrera(short num);
	
	Carrera findCarreraBynombrecarrera(String nombrecarrera);

}
