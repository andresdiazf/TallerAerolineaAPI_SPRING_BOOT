package com.genjava11.AerolineaAppi.service;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {
    private final PasajeroRepository pasajeroRepository;

    @Autowired

    public PasajeroService(PasajeroRepository pasajeroRepository) {this.pasajeroRepository = pasajeroRepository;}

    public List<Pasajero> findAll(){return pasajeroRepository.findAll();} // es como select * from pasajeros
    public Pasajero Save(Pasajero pasajero){ return pasajeroRepository.save(pasajero);} // es como hacer Insert o Update en pasajeros

}
