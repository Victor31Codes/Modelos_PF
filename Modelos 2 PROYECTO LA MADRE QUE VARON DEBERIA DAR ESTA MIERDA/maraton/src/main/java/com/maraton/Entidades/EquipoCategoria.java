package com.maraton.Entidades;
// Generated 19 nov. 2023 09:25:49 by Hibernate Tools 4.3.6.Final

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * EquipoCategoria generated by hbm2java
 */
@Entity
@Table(name = "equipo_categoria", schema = "public")
public class EquipoCategoria implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEquipocat;
	private Categoria categoria;
	private Equipo equipo;

	public EquipoCategoria() {
	}

	public EquipoCategoria(int idEquipocat, Categoria categoria, Equipo equipo) {
		this.idEquipocat = idEquipocat;
		this.categoria = categoria;
		this.equipo = equipo;
	}

	@Id

	@Column(name = "id_equipocat", unique = true, nullable = false, precision = 5, scale = 0)
	public int getIdEquipocat() {
		return this.idEquipocat;
	}

	public void setIdEquipocat(int idEquipocat) {
		this.idEquipocat = idEquipocat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
