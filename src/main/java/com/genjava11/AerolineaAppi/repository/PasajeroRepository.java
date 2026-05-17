package com.genjava11.AerolineaAppi.repository;

import com.genjava11.AerolineaAppi.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

}
