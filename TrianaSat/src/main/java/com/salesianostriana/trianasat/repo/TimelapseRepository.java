package com.salesianostriana.trianasat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.Timelapse;

@RepositoryRestResource(collectionResourceRel = "timelapse", path = "timelapse")
public interface TimelapseRepository extends JpaRepository<Timelapse, Long> {

}
