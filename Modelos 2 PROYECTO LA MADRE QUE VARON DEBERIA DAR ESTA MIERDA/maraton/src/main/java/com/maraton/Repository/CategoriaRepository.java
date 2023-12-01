package com.maraton.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraton.Entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	
	Categoria findCategoriaByidCategoria (byte id);
	
	

}
