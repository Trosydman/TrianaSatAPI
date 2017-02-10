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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

/**
 * Created by aalvarez on 27/01/2017.
 */

// clase donde se recoge los datos registrados desde el dispositivo movil.
@Entity
@Table(name = "TIMELAPSE")
public class Timelapse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// atributo tipo long, recoge la fecha y la hora tomada en cada instante del
	// movil.
	@Column
	@NotNull
	private long fecha;
	
	@Column (name="foto")
	@NotNull
	private String foto;
	
	// atributo tipo double, recoge el valor numerico del estado de la bateria
	// del movil
	@Column(name="estado_bateria")
	@DecimalMax(value = "100.00")
	@NotNull
	private double estado_bateria;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proyecto")
	@NotNull
	private Proyecto proyecto;

	public Timelapse() {
	}

	public Timelapse(long id, long fecha, String foto, double estado_bateria, Proyecto proyecto) {
		this.id = id;
		this.fecha = fecha;
		this.foto = foto;
		this.estado_bateria = estado_bateria;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getEstado_bateria() {
		return estado_bateria;
	}

	public void setEstado_bateria(double estado_bateria) {
		this.estado_bateria = estado_bateria;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "Timelapse [id=" + id + ", fecha=" + fecha + ", foto=" + foto + ", estado_bateria=" + estado_bateria
				+ ", proyecto=" + proyecto + "]";
	}

	

}
