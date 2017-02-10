package com.salesianostriana.trianasat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by aalvarez on 27/01/2017.
 */

// Todos los datos que vamos a recibir de los sensores
// relacionados con la fecha y hora en el que fueron tomados

@Entity
@Table(name = "DATOS_SENSORES")
public class DatosSensores {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotNull
	private long fecha;

	@Column
	private double altitud;

	@Column
	private double temperatura;

	@Column
	private double presion;

	@Column
	private double calidad_aire;

	@Column
	private double humedad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proyecto")
	@NotNull
	private Proyecto proyecto;

	public DatosSensores() {
	}

	public DatosSensores(long id, long fecha, double altitud, double temperatura, double presion, double calidad_aire,
			double humedad, Proyecto proyecto) {
		this.id = id;
		this.fecha = fecha;
		this.altitud = altitud;
		this.temperatura = temperatura;
		this.presion = presion;
		this.calidad_aire = calidad_aire;
		this.humedad = humedad;
		this.proyecto = proyecto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public double getAltitud() {
		return altitud;
	}

	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getPresion() {
		return presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}

	public double getCalidad_aire() {
		return calidad_aire;
	}

	public void setCalidad_aire(double calidad_aire) {
		this.calidad_aire = calidad_aire;
	}

	public double getHumedad() {
		return humedad;
	}

	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "DatosSensores [id=" + id + ", fecha=" + fecha + ", altitud=" + altitud + ", temperatura=" + temperatura
				+ ", presion=" + presion + ", calidad_aire=" + calidad_aire + ", humedad=" + humedad + ", proyecto="
				+ proyecto + "]";
	}

	
}
