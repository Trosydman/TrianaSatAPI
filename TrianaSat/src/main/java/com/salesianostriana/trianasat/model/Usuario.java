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

// clase con los datos de cada usuario.
@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// atributo tipo String, recoge el nombre del usuario.
	@Column
	@NotNull
	private String nombre;
	// atribut tipo String, recoge los apellidos del usuario.
	@Column
	@NotNull
	private String apellidos;
	// atributo tipo String, recoge el correo electronico del usuario
	@Column(unique=true)
	@NotNull
	private String email;
	// atributo tipo String, recoge el password del usuario.
	@Column
	@NotNull
	private String password;
	// atributo tipo Organizacion, recoge los datos de la organizacion a la que
	// pertenece el usuario.
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_id")
	@NotNull
	private Organizacion organizacion;
	// atributo tipo boleano, recoge el valor que confirma si el usuario es
	// administrador o no.
	@Column
	@NotNull
	private boolean administrador;
	
	
	public Usuario() {
	}
	public Usuario(String nombre, String apellidos, String email, String password, Organizacion organizacion,
			boolean administrador) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.organizacion = organizacion;
		this.administrador = administrador;
	}
	public Usuario(long id, String nombre, String apellidos, String email, String password, Organizacion organizacion,
			boolean administrador) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.organizacion = organizacion;
		this.administrador = administrador;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", organizacion=" + organizacion + ", administrador=" + administrador
				+ "]";
	}
	
	

	
}
