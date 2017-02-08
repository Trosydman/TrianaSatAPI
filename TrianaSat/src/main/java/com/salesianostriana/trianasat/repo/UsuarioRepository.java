package com.salesianostriana.trianasat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByEmailAndPassword(String email, String password);
	
}
