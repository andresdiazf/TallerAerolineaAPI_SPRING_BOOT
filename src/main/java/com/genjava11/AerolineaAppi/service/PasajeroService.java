package com.genjava11.AerolineaAppi.service;

import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class PasajeroService {
    private final PasajeroRepository pasajeroRepository;

    @Autowired

    public PasajeroService(PasajeroRepository pasajeroRepository) {this.pasajeroRepository = pasajeroRepository;}

    public List<Pasajero> findAll(){return pasajeroRepository.findAll();} // es como select * from pasajero

    public Pasajero findById(Long id){return pasajeroRepository.findById(id).orElse(null);}

    public Pasajero save(Pasajero pasajero){ return pasajeroRepository.save(pasajero);} // es como hacer Insert o Update en pasajeros

    public Pasajero update(Long id, Pasajero pasajero) {
        Pasajero existente = pasajeroRepository.findById(id).orElse(null);
        if (existente == null) return null;
            existente.setNombre(pasajero.getNombre());
            existente.setApellido(pasajero.getApellido());
            existente.setEmail(pasajero.getEmail());
            existente.setDocumento(pasajero.getDocumento());
            return pasajeroRepository.save(existente);
        }
    public Pasajero patch(Long id, Map<String, Object> campos) {
        Pasajero existente = pasajeroRepository.findById(id).orElse(null);
        if (existente == null) return null;

        // Solo actualiza los campos que lleguen en el body
        if (campos.containsKey("nombre"))    existente.setNombre((String) campos.get("nombre"));
        if (campos.containsKey("apellido"))  existente.setApellido((String) campos.get("apellido"));
        if (campos.containsKey("email"))     existente.setEmail((String) campos.get("email"));
        if (campos.containsKey("documento")) existente.setDocumento((String) campos.get("documento"));

        return pasajeroRepository.save(existente);
    }
    public void delete(Long id){pasajeroRepository.deleteById(id);}
}

