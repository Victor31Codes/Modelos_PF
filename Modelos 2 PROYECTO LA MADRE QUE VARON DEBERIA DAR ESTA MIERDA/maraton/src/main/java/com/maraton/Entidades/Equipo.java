 package com.maraton.Entidades;
// Generated 19 nov. 2023 09:25:49 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "equipo", schema = "public")
public class Equipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idEquipo;
	
	
	private String nombreequipo;
	private Set<Estudiante> estudiantes = new HashSet<Estudiante>(0);
	private Set<EquipoCategoria> equipoCategorias = new HashSet<EquipoCategoria>(0);

	public Equipo() {
	}

	public Equipo(short idEquipo, String nombreequipo) {
		this.idEquipo = idEquipo;
		this.nombreequipo = nombreequipo;
	}

	public Equipo(short idEquipo, String nombreequipo, Set<Estudiante> estudiantes, Set<EquipoCategoria> equipoCategorias) {
		this.idEquipo = idEquipo;
		this.nombreequipo = nombreequipo;
		this.estudiantes = estudiantes;
		this.equipoCategorias = equipoCategorias;
	}

	@Id

	@Column(name = "id_equipo", unique = true, nullable = false, precision = 4, scale = 0)
	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Column(name = "nombreequipo", nullable = false, length = 45)
	public String getNombreequipo() {
		return this.nombreequipo;
	}

	public void setNombreequipo(String nombreequipo) {
		this.nombreequipo = nombreequipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<EquipoCategoria> getEquipoCategorias() {
		return this.equipoCategorias;
	}

	public void setEquipoCategorias(Set<EquipoCategoria> equipoCategorias) {
		this.equipoCategorias = equipoCategorias;
	}

}
