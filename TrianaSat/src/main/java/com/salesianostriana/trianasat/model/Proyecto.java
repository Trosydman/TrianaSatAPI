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

	public Proyecto(long id, long fecha_creacion, long fecha_lanzamiento, String nombre, String descripcion,
			String localidad, String token, String api_key, String api_secret, String access_token,
			String access_token_secret, List<Gps> gps, List<Timelapse> timelapse, List<DatosSensores> datos_sensores,
			Organizacion organizacion) {
		this.id = id;
		this.fecha_creacion = fecha_creacion;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.localidad = localidad;
		this.token = token;
		this.api_key = api_key;
		this.api_secret = api_secret;
		this.access_token = access_token;
		this.access_token_secret = access_token_secret;
		this.gps = gps;
		this.timelapse = timelapse;
		this.datos_sensores = datos_sensores;
		this.organizacion = organizacion;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getFecha_creacion() {
		return fecha_creacion;
	}



	public void setFecha_creacion(long fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}



	public long getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}



	public void setFecha_lanzamiento(long fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
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



	public String getApi_key() {
		return api_key;
	}



	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}



	public String getApi_secret() {
		return api_secret;
	}



	public void setApi_secret(String api_secret) {
		this.api_secret = api_secret;
	}



	public String getAccess_token() {
		return access_token;
	}



	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}



	public String getAccess_token_secret() {
		return access_token_secret;
	}



	public void setAccess_token_secret(String access_token_secret) {
		this.access_token_secret = access_token_secret;
	}



	public List<Gps> getGps() {
		return gps;
	}



	public void setGps(List<Gps> gps) {
		this.gps = gps;
	}



	public List<Timelapse> getTimelapse() {
		return timelapse;
	}



	public void setTimelapse(List<Timelapse> timelapse) {
		this.timelapse = timelapse;
	}



	public List<DatosSensores> getDatos_sensores() {
		return datos_sensores;
	}



	public void setDatos_sensores(List<DatosSensores> datos_sensores) {
		this.datos_sensores = datos_sensores;
	}



	public Organizacion getOrganizacion() {
		return organizacion;
	}



	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}



	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", fecha_creacion=" + fecha_creacion + ", fecha_lanzamiento=" + fecha_lanzamiento
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", localidad=" + localidad + ", token="
				+ token + ", api_key=" + api_key + ", api_secret=" + api_secret + ", access_token=" + access_token
				+ ", access_token_secret=" + access_token_secret + ", gps=" + gps + ", timelapse=" + timelapse
				+ ", datos_sensores=" + datos_sensores + ", organizacion=" + organizacion + "]";
	}

	
	

}
