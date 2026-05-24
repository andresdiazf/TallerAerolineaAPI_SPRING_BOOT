package com.genjava11.AerolineaAppi.DTO;

import com.genjava11.AerolineaAppi.model.ClaseAsiento;
import java.time.LocalDateTime;

public class ReservaRequestDTO {

    private LocalDateTime fechaReserva;
    private ClaseAsiento claseAsiento;
    private Long pasajeroId;
    private Long vueloId;

    public ReservaRequestDTO() {}

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

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}
