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

@Entity
@Table(name="GPS")
public class Gps {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column
	@NotNull
	private long fecha;
	
	@Column
	@NotNull
    private double lat;
	
	@Column
	@NotNull
    private double lng;
    
	@Column(name="estado_bateria")
	@DecimalMax(value = "100.00")
	@NotNull
	private double estado_bateria;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proyecto")
	@NotNull
	private Proyecto proyecto;

	public Gps() {
	}

	public Gps(long id, long fecha, double lat, double lng, double estadoBateria, Proyecto proyecto) {
		this.id = id;
		this.fecha = fecha;
		this.lat = lat;
		this.lng = lng;
		this.estado_bateria = estadoBateria;
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
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
		return "Gps [id=" + id + ", fecha=" + fecha + ", lat=" + lat + ", lng=" + lng + ", estadoBateria="
				+ estado_bateria + ", proyecto=" + proyecto + "]";
	}
	
	
	
}
