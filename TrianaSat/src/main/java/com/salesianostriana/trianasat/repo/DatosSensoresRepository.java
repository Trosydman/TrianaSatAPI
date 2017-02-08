package com.salesianostriana.trianasat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.DatosSensores;

@RepositoryRestResource(collectionResourceRel = "datossensores", path = "datossensores")
public interface DatosSensoresRepository extends JpaRepository<DatosSensores, Long> {
}
