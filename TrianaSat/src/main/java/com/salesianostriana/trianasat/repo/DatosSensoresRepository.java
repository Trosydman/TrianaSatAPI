package com.salesianostriana.trianasat.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salesianostriana.trianasat.model.DatosSensores;

@RepositoryRestResource(collectionResourceRel = "datossensores", path = "datossensores")
public interface DatosSensoresRepository extends JpaRepository<DatosSensores, Long> {
	
	//@Query(value="SELECT LIMIT 1 * FROM DATOS_SENSORES WHERE fecha < ?1 ORDER BY fecha DESC")
	List<DatosSensores> /*getLastDS*/findByFechaLessThanEqualOrderByFechaAsc(@Param("fecha") Long fecha);
	
	/*default DatosSensores getLastDS(){
		return findByFechaLessThanEqualOrderByFechaDesc(new Date().getTime()).get(0);
	}*/
}
