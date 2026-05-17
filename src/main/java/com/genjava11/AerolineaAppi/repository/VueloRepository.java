package com.genjava11.AerolineaAppi.repository;

import com.genjava11.AerolineaAppi.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
