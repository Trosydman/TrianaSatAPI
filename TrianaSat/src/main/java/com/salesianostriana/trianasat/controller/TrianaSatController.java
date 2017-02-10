package com.salesianostriana.trianasat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	//TODO Cambiar Usuario por parámetros necesarios (email, password) 
	public /*@ResponseBody*/ Organizacion login(@RequestParam String email, @RequestParam String password){
		//TODO Meter código de SpringSession/Security?...
		List<Usuario> usuarios = repoUsuario.findByEmailAndPassword(email, password);
		try {
			if(usuarios.size()==1){
				Organizacion org = usuarios.get(0).getOrganizacion(); 
				return org;
			}
			return new Organizacion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Organizacion();
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public @ResponseBody Usuario logout(@RequestBody Usuario usuario){
		//TODO Meter código de SpringSession/Security?...
		return null;
	}
	
	@RequestMapping(value="/proyecto", method=RequestMethod.GET)
	public List<Proyecto> findByToken(@RequestParam(value = "token", required = true)String token){
		//TODO Meter código de SpringSession/Security?...
		return repoProy.findByToken(token);
	}
}
