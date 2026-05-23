package com.genjava11.AerolineaAppi.service;

import com.genjava11.AerolineaAppi.DTO.ReservaRequestDTO;
import com.genjava11.AerolineaAppi.DTO.ReservaResponseDTO;
import com.genjava11.AerolineaAppi.model.Pasajero;
import com.genjava11.AerolineaAppi.model.Reserva;
import com.genjava11.AerolineaAppi.model.Vuelo;
import com.genjava11.AerolineaAppi.repository.PasajeroRepository;
import com.genjava11.AerolineaAppi.repository.ReservaRepository;
import com.genjava11.AerolineaAppi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, PasajeroRepository pasajeroRepository, VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }
    public List<ReservaResponseDTO> findAll(){
        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

   public ReservaResponseDTO findById(long id){
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if(reserva == null) return null;
        return ReservaResponseDTO.desde(reserva);
   }

   public ReservaResponseDTO save(ReservaRequestDTO dto) {
       Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
       Vuelo vuelo = vueloRepository.findById(dto.getVueloID()).orElse(null);
       Reserva reserva = new Reserva(dto.getFechaReserva(),dto.getClaseAsiento(),pasajero,vuelo);
       return ReservaResponseDTO.desde(reservaRepository.save(reserva));
   }

   public ReservaResponseDTO update(long id, ReservaRequestDTO dto) {
        Reserva existente = reservaRepository.findById(id).orElse(null);
        if(existente == null) return null;
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        existente.setFechaReserva(dto.getFechaReserva());
        existente.setClaseAsiento(dto.getClaseAsiento());
        existente.setPasajero(pasajero);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloID()).orElse(null);
        existente.setVuelo(vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(existente));
   }

   public void delete(long id) {reservaRepository.deleteById(id);}

}




