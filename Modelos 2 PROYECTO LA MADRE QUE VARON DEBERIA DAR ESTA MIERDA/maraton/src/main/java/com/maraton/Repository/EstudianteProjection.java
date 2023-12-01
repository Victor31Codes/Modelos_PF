package com.maraton.Repository;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.maraton.Entidades.Carrera;

@JsonPropertyOrder({"nombres","carrera"})
public interface EstudianteProjection {
	
    String getNombres();
    Carrera getCarrera();

}
