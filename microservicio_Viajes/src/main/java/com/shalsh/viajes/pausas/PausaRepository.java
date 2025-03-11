package com.shalsh.viajes.pausas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shalsh.viajes.viajes.Viaje;

@Repository
public interface PausaRepository extends JpaRepository<Pausa,Integer> {

	List<Pausa> findAllByViaje(Viaje viaje);

}
