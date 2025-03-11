package com.shalsh.viajes.viajes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shalsh.viajes.dto.ViajeDTO;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje,Integer> {

	List<Viaje> reporte(Integer valueOf);

}
