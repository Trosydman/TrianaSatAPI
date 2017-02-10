package com.salesianostriana.trianasat.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by aalvarez on 27/01/2017.
 */

// clase padre donde se recoge los datos de forma general, siendo la conexion
// principal de las demas clases.
@Entity
@Table(name = "PROYECTO")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	@NotNull
	private long fecha_creacion;
	
	@Column
	@NotNull
	private long fecha_lanzamiento;

	// atributo tipo String, recoge el nombre del proyecto.
	@Column
	@NotNull
	private String nombre;
	// atributo tipo String, recoge una breve descripcion sobre el proposito del
	// proyecto
	@Column
	private String descripcion;
	// atributo tipo String, recoge el dato del nombre del lugar donde se
	// realiza.
	@Column
	@NotNull
	private String localidad;
	
	// atributo tipo String, recoge el valor generado servira de
	// identificador(valor alfanumerico)
	//@Column(unique=true)
	@Column(unique=true)
	@NotNull
	private String token;
	
	@Column
	private String api_key;
	
	@Column
	private String api_secret;
	
	@Column
	private String access_token;
	
	@Column
	private String access_token_secret;

	// atributo tipo List, recoge una lista de Gps con los valores de situacion
	// geografica.
	@OneToMany(mappedBy = "proyecto")
	private List<Gps> gps;//listaGps;

	// atributo tipo List, recoge una lista de Timelapse con los valores
	// recogidos del dispositivo movil.
	@OneToMany(mappedBy = "proyecto")
	private List<Timelapse> timelapse;//listaTimelapse;

	// atributo tipo List, recoge una lista de DatosSensores con los valores
	// recogidos de los sensores del tracker.
	@OneToMany(mappedBy = "proyecto")
	private List<DatosSensores> datos_sensores;//listaDatosSensores;

	// atributo tipo Organizacion, recoge los datos sobre la organizacion a la
	// que pertenece el proyecto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")
	@NotNull
	private Organizacion organizacion;
	
	

	public Proyecto() {
		super();
	}

	public Proyecto(long id, String nombre, String descripcion, String localidad, /*String token,*/
			Organizacion organizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.localidad = localidad;
		//this.token = token;
		this.organizacion = organizacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", localidad=" + localidad
				+ ", token=" + getToken() + ", organizacion=" + organizacion + "]";
	}

}
