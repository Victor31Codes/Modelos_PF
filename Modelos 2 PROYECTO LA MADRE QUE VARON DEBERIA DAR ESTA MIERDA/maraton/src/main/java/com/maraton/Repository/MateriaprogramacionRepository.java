package com.maraton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraton.Entidades.Materiaprogramacion;

public interface MateriaprogramacionRepository extends JpaRepository<Materiaprogramacion,Long>  {
	
	Materiaprogramacion findMateriaprogramacionByidMateria(short num);

}
