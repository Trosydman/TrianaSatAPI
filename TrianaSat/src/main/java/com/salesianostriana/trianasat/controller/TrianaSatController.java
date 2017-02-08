package com.salesianostriana.trianasat.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.trianasat.model.Organizacion;
import com.salesianostriana.trianasat.model.Proyecto;
import com.salesianostriana.trianasat.model.Usuario;
import com.salesianostriana.trianasat.model.UsuarioURL;
import com.salesianostriana.trianasat.repo.OrganizacionRepository;
import com.salesianostriana.trianasat.repo.ProyectoRepository;
import com.salesianostriana.trianasat.repo.UsuarioRepository;

@RestController
public class TrianaSatController {
	
	@Autowired
	OrganizacionRepository repoOrg;
	
	@Autowired
	UsuarioRepository repoUsuario;
	
	@Autowired
	ProyectoRepository repoProy;
	
	/*@RequestMapping(value="/signin", method=RequestMethod.POST)
	public @ResponseBody Usuario sigin(@RequestBody Usuario usuario){
		return repoUsuario.save(usuario);
	}*/
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public @ResponseBody Usuario sigin(@RequestBody UsuarioURL usUrl){
		//Se obtiene la organizacion a partir de la id del final de la urlOrg
		Organizacion orgUsuario = repoOrg.findOne(Long.parseLong(usUrl.getOrganizacion().split("/")[usUrl.getOrganizacion().split("/").length-1]));
		Usuario usuario = new Usuario(usUrl.getNombre(), usUrl.getApellidos(), usUrl.getEmail(), usUrl.getPassword(), orgUsuario, usUrl.isAdministrador());
		return repoUsuario.save(usuario);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	//TODO Cambiar Usuario por parámetros necesarios (email, password) 
	public @ResponseBody boolean login(@RequestBody Usuario usuario){
		//TODO Meter código de SpringSession/Security?...
		if(repoUsuario.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword()).contains(usuario)){
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public Usuario logout(@RequestBody Usuario usuario){
		//TODO Meter código de SpringSession/Security?...
		return null;
	}
	
	/*@RequestMapping(value="/proyecto", method=RequestMethod.GET)
	public List<Proyecto> findByToken(@ModelAttribute("token")String token, Model model){
		//TODO Meter código de SpringSession/Security?...
		return repoProy.findByToken(token);
	}*/
}
