package com.genjava11.AerolineaAppi.DTO;
import com.genjava11.AerolineaAppi.model.ClaseAsiento;
import com.genjava11.AerolineaAppi.model.Reserva;


import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private LocalDateTime fechaReserva;
    private ClaseAsiento claseAsiento;
    private Long pasajeroId;
    private String pasajeroNombre;
    private String pasajeroApellido;
    private String vueloOrigen;
    private String vueloDestino;
    private Long  vueloId;

    public ReservaResponseDTO() {}

    public static ReservaResponseDTO desde(Reserva reserva){
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.id = reserva.getId();
        dto.fechaReserva = reserva.getFechaReserva();
        dto.claseAsiento = reserva.getClaseAsiento();
        dto.pasajeroId = reserva.getPasajero().getId();
        dto.pasajeroNombre = reserva.getPasajero().getNombre();
        dto.pasajeroApellido = reserva.getPasajero().getApellido();
        dto.vueloOrigen = reserva.getVuelo().getOrigen();
        dto.vueloDestino = reserva.getVuelo().getDestino();
        dto.vueloId = reserva.getVuelo().getId();
        return  dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ClaseAsiento getClaseAsiento() {
        return claseAsiento;
    }

    public void setClaseAsiento(ClaseAsiento claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public String getPasajeroNombre() {
        return pasajeroNombre;
    }

    public void setPasajeroNombre(String pasajeroNombre) {
        this.pasajeroNombre = pasajeroNombre;
    }

    public String getPasajeroApellido() {
        return pasajeroApellido;
    }

    public void setPasajeroApellido(String pasajeroApellido) {
        this.pasajeroApellido = pasajeroApellido;
    }

    public String getVueloOrigen() {
        return vueloOrigen;
    }

    public void setVueloOrigen(String vueloOrigen) {
        this.vueloOrigen = vueloOrigen;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }

    public void setVueloDestino(String vueloDestino) {
        this.vueloDestino = vueloDestino;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}
