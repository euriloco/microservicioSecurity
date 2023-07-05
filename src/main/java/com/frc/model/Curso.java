package com.frc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	private String codCurso;
	private String nombre;
	private int horas;
	private double precio;
	
	// CONSTRUCTORES
	public Curso() {
		super();
	}

	public Curso(String codCurso, String nombre, int horas, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.horas = horas;
		this.precio = precio;
	}

	// GETTERS y SETTERS
	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
