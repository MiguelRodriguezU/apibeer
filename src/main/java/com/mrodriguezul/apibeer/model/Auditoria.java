package com.mrodriguezul.apibeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Auditoria")
public class Auditoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "recurso")
	private String recurso;
	
	@Column(name = "fechaHora")
	private String fechaHora;
	
	@Column(name = "duracion")
	private Long duracion;

	public Auditoria() {
		super();
	}

	public Auditoria(Integer id, String recurso, String fechaHora, Long duracion) {
		super();
		this.id = id;
		this.recurso = recurso;
		this.fechaHora = fechaHora;
		this.duracion = duracion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Auditoria [id=" + id + ", recurso=" + recurso + ", fechaHora=" + fechaHora + ", duracion=" + duracion
				+ "]";
	}
	
}
