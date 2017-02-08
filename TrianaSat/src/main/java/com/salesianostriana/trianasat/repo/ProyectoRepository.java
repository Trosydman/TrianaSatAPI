package com.salesianostriana.trianasat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.Proyecto;

@RepositoryRestResource(collectionResourceRel = "proyectos", path = "proyectos")
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
	
	//@Query("select p from Proyecto p where p.token = ?1")
	List<Proyecto> findByToken(@Param("token") String token);
}
