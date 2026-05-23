package com.genjava11.AerolineaAppi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Enumerated(EnumType.STRING)
    private ClaseAsiento claseAsiento;

    /*
    Una reserva representa el acto de un pasajero de tomar asiento en un vuelo. Tiene fecha de reserva, clase de asiento, y dos relaciones: pertenece a un Pasajero y a un Vuelo. Esas relaciones son @ManyToOne — muchas reservas pueden pertenecer al mismo pasajero, y muchas reservas pueden estar en el mismo vuelo.

    Vuelo y Pasajero NO necesitan lista de reservas (@OneToMany). La relación solo vive en Reserva. Esto  evita ciclos de serialización sin necesidad de anotaciones adicionales en los modelos existentes.
    */

    @ManyToOne
    @JoinColumn(name="pasajero_id",nullable = false)
    private  Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name ="vuelo_id",nullable = false)
    private  Vuelo vuelo;

    public Reserva(LocalDateTime fechaReserva, ClaseAsiento claseAsiento, Pasajero pasajero, Vuelo vuelo) {
    }

    public Reserva(Long id, LocalDateTime fechaReserva, ClaseAsiento claseAsiento, Pasajero pasajero, Vuelo vuelo) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.claseAsiento = claseAsiento;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
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

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
