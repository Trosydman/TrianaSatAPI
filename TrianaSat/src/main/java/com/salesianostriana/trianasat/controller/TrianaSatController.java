package com.salesianostriana.trianasat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.trianasat.model.Organizacion;
import com.salesianostriana.trianasat.model.Proyecto;
import com.salesianostriana.trianasat.model.Usuario;
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
	public Usuario signin(@RequestBody Usuario user){
		return repoUsuario.save(user);
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public HttpEntity<Organizacion> login(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, HttpServletRequest request){
		//TODO Meter código de SpringSession/Security?...
		List<Usuario> usuarios = repoUsuario.findByEmailAndPassword(email, password);
		if(usuarios.size()==1){
			Organizacion org = usuarios.get(0).getOrganizacion();
			org.add(getOrgLinks(org, request));
			return new ResponseEntity<Organizacion>(org,HttpStatus.OK);
		}
		return new ResponseEntity<Organizacion>(HttpStatus.NOT_FOUND);
	}
	
	/*@RequestMapping(value="/logout", method=RequestMethod.GET)
	public @ResponseBody Usuario logout(@RequestBody Usuario usuario){
		//TODO Meter código de SpringSession/Security?...
		return null;
	}*/
	
	@RequestMapping(value="/proyecto", method=RequestMethod.POST)
	public HttpEntity<Proyecto> findByToken(@RequestParam(value = "token", required = true)String token, HttpServletRequest request){
		//TODO Meter código de SpringSession/Security?...
		List<Proyecto> proy = repoProy.findByToken(token);
		
		if(proy.size()==1){
			Proyecto pFinal = proy.get(0);
			pFinal.add(getProyLinks(proy.get(0), request));
			return new ResponseEntity<Proyecto>(pFinal, HttpStatus.OK);
		} else
			return new ResponseEntity<Proyecto>(HttpStatus.CONFLICT);
	}
	
	/* ===============================================================================================================================
	 * ===============================================================================================================================
	 */
	
	private List<Link> getOrgLinks(Organizacion org, HttpServletRequest request){
		List<Link> orgLinks = new ArrayList<Link>();
		//TODO intentar obtener el Link mediante org.getId() -> Por qué es null?
		String urlSelf = request.getRequestURL().toString().replace("login", "organizaciones")+"/"+org.getIdLong();
		
		orgLinks.add(new Link(urlSelf).withSelfRel());
		orgLinks.add(new Link(urlSelf,"organizacion"));
		orgLinks.add(new Link(urlSelf+"/listaProyectos","listaProyectos"));
		orgLinks.add(new Link(urlSelf+"/listaUsuarios","listaUsuarios"));
		
		return orgLinks;
	}
	
	private List<Link> getProyLinks(Proyecto proy, HttpServletRequest request){
		List<Link> proyLinks = new ArrayList<Link>();
		//TODO intentar obtener el Link mediante org.getId() -> Por qué es null?
		String urlSelf = request.getRequestURL().toString().replace("login", "proyectos")+"/"+proy.getIdLong();
		
		proyLinks.add(new Link(urlSelf).withSelfRel());
		proyLinks.add(new Link(urlSelf,"proyectos"));
		proyLinks.add(new Link(urlSelf+"/timelapse","timelapse"));
		proyLinks.add(new Link(urlSelf+"/gps","gps"));
		proyLinks.add(new Link(urlSelf+"/organizacion","organizacion"));
		proyLinks.add(new Link(urlSelf+"/datos_sensores","datos_sensores"));
		
		return proyLinks;
	}
	
}
