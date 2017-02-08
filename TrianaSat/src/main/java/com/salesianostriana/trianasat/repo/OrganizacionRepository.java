package com.salesianostriana.trianasat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.Organizacion;

@RepositoryRestResource(collectionResourceRel = "organizaciones", path = "organizaciones")
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
	
}
