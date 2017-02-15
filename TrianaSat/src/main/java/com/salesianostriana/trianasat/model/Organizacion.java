package com.salesianostriana.trianasat.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aalvarez on 27/01/2017.
 */

//La organización está formada por muchos usuarios y por un solo usuario que es administrador
@Entity
@Table(name="ORGANIZACION")
public class Organizacion extends ResourceSupport{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	@NotNull
    private String nombre;
	
	@Column
	private String descripcion;
	
	@OneToMany(mappedBy = "organizacion")
    private List<Usuario>listaUsuarios;
	
	@OneToMany(mappedBy = "organizacion")
    private List<Proyecto>listaProyectos;


    public Organizacion() {
    }

	public Organizacion(Long id, String nombre, String descripcion, List<Usuario> listaUsuarios,
			List<Proyecto> listaProyectos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaUsuarios = listaUsuarios;
		this.listaProyectos = listaProyectos;
	}
    
	@JsonCreator
	public Organizacion(@JsonProperty("nombre")String nombre, @JsonProperty("descripcion")String descripcion,
			@JsonProperty("listaUsuarios")List<Usuario> listaUsuarios,  @JsonProperty("listaProyecto")List<Proyecto> listaProyectos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaUsuarios = listaUsuarios;
		this.listaProyectos = listaProyectos;
	}

	@JsonIgnore
	public Long getIdLong(){
		return id;
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


	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}


	public void setListaProyectos(List<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}


	@Override
	public String toString() {
		return "Organizacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", listaUsuarios="
				+ listaUsuarios + ", listaProyectos=" + listaProyectos + "]";
	}
    
}
