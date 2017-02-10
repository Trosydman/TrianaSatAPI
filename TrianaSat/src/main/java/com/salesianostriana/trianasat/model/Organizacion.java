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

/**
 * Created by aalvarez on 27/01/2017.
 */

//La organización está formada por muchos usuarios y por un solo usuario que es administrador
@Entity
@Table(name="ORGANIZACION")
public class Organizacion {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
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

    public Organizacion(long id, String nombre, List<Usuario> listaUsuarios) {
    	this.id = id;
        this.nombre = nombre;
        this.listaUsuarios = listaUsuarios;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    @Override
    public String toString() {
        return "Organizacion{" +
                "nombre='" + nombre + '\'' +
                ", listaUsuarios=" + listaUsuarios +
                '}';
    }
}
