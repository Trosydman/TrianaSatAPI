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
	private Long id;

	// atributo tipo long, recoge la fecha y la hora tomada en cada instante del
	// movil.
	@Column(name="fecha_captura")
	@NotNull
	private long fecha_captura;
	
	@Column(name="fecha_subida")
	@NotNull
	private String fecha_subida;
	
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

	public Timelapse(long id, long fecha_captura, String fecha_subida, String foto, double estado_bateria,
			Proyecto proyecto) {
		this.id = id;
		this.fecha_captura = fecha_captura;
		this.fecha_subida = fecha_subida;
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

	public long getFecha_captura() {
		return fecha_captura;
	}

	public void setFecha_captura(long fecha_captura) {
		this.fecha_captura = fecha_captura;
	}

	public String getFecha_subida() {
		return fecha_subida;
	}

	public void setFecha_subida(String fecha_subida) {
		this.fecha_subida = fecha_subida;
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
		return "Timelapse [id=" + id + ", fecha_captura=" + fecha_captura + ", fecha_subida=" + fecha_subida + ", foto="
				+ foto + ", estado_bateria=" + estado_bateria + ", proyecto=" + proyecto + "]";
	}

		

}
