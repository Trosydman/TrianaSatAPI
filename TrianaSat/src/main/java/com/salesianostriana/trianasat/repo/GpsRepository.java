package com.salesianostriana.trianasat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.Gps;

@RepositoryRestResource(collectionResourceRel = "gps", path = "gps")
public interface GpsRepository extends JpaRepository<Gps, Long>{

}
