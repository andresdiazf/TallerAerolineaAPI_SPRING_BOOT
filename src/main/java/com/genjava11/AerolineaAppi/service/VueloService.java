package com.genjava11.AerolineaAppi.service;

import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {this.vueloRepository = vueloRepository;}

    public List<Vuelo> findAll(){return vueloRepository.findAll();} // es como select * from vuelos

    public Vuelo findById(Long id){return vueloRepository.findById(id).orElse(null);}

    public Vuelo save(Vuelo vuelo){return vueloRepository.save(vuelo);} // es como hacer Insert o Update en tabla vuelos

    public Vuelo update(Long id, Vuelo vuelo){
        Vuelo existente = vueloRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setOrigen(vuelo.getOrigen());
        existente.setDestino(vuelo.getDestino());
        existente.setEstado(vuelo.getEstado());
        existente.setFechaHora(vuelo.getFechaHora());
        return vueloRepository.save(existente);
    }
    public void delete(Long id){vueloRepository.deleteById(id);}

}
